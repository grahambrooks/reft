package reft.processor;

import com.sun.source.tree.*;
import com.sun.source.util.SourcePositions;
import com.sun.source.util.TreePath;
import com.sun.source.util.TreePathScanner;
import com.sun.source.util.Trees;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeInfo;
import com.sun.tools.javac.util.List;
import reft.migration.MigrationDriver;
import reft.model.QualifiedName;
import reft.model.ClassModelMap;
import reft.model.DefaultJavaClassDeclaration;
import reft.model.LocationInfo;
import reft.model.MethodInvocation;
import reft.helper.LocationInfoSetter;
import reft.helper.ScanHelper;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.ArrayList;

import static com.googlecode.totallylazy.Sequences.sequence;

public class MigrationTreePathScanner extends TreePathScanner<Object, Trees> implements JavaScanner {
    private final DefaultJavaClassDeclaration clazzInfo = new DefaultJavaClassDeclaration();
    private final ClassModelMap model;
    private final MigrationDriver driver;

    public MigrationTreePathScanner(ClassModelMap model, MigrationDriver analyzer) {
        this.model = model;
        this.driver = analyzer;
    }

    @Override
    public Object visitImport(ImportTree node, Trees trees) {
        return super.visitImport(node, trees);
    }

    @Override
    public Object visitMethodInvocation(MethodInvocationTree node, Trees trees) {
        Symbol.MethodSymbol method = (Symbol.MethodSymbol) TreeInfo.symbol((JCTree) node.getMethodSelect());
        if (method != null) {
            TypeElement invokedClass = (TypeElement) method.getEnclosingElement();
            List<Symbol.VarSymbol> parameters = method.getParameters();

            QualifiedName methodName = new QualifiedName(invokedClass.toString(), method.getQualifiedName().toString());


            LocationInfo nameLocation = new LocationInfo();
            SourcePositions sourcePosition = trees.getSourcePositions();
            long startPosition = sourcePosition.getStartPosition(getCurrentPath().getCompilationUnit(), node);
            nameLocation.setStartOffset((int) startPosition);


            MethodInvocation methodInvocation = new MethodInvocation(methodName, nameLocation, sequence(parameters).foldLeft(new ArrayList<>(), (list, vs) -> {
                list.add(vs.asType().toString());
                return list;
            }));

            driver.apply(methodInvocation);
        }
        return super.visitMethodInvocation(node, trees);
    }

    @Override
    public Object visitClass(ClassTree classTree, Trees trees) {

        ScanHelper.populateClassDeclaration(clazzInfo, classTree, getCurrentPath(), trees);
        return super.visitClass(classTree, trees);
    }

    @Override
    public Object visitMethod(MethodTree methodTree, Trees trees) {
        TreePath path = getCurrentPath();

        ScanHelper.populateMethodDeclaration(clazzInfo, methodTree, path, trees);
        return super.visitMethod(methodTree, trees);
    }

    @Override
    public Object visitVariable(VariableTree variableTree, Trees trees) {
        TreePath path = getCurrentPath();
        Element e = trees.getElement(path);

        ScanHelper.populateFieldDeclaration(clazzInfo, variableTree, e, path, trees);
        return super.visitVariable(variableTree, trees);
    }

    public void scan(TypeElement e, TreePath tp, Trees trees) {
        super.scan(tp, trees);
        completeScan(e);
    }

    private void completeScan(TypeElement e) {
        String className = e.getQualifiedName().toString();

        LocationInfoSetter.setLocationInfoForElements(clazzInfo);

        model.addClassInfo(className, clazzInfo);
    }
}

