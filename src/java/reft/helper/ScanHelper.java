package reft.helper;

import com.sun.source.tree.*;
import com.sun.source.util.SourcePositions;
import com.sun.source.util.TreePath;
import com.sun.source.util.Trees;
import reft.model.*;

import javax.lang.model.element.*;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleElementVisitor6;
import java.util.List;

import static reft.util.CodeAnalyzerConstants.DEFAULT_CONSTRUCTOR_NAME;
import static reft.util.CodeAnalyzerConstants.SERIALIZABLE_PKG;

public class ScanHelper {
    public static void populateAnnotationDeclaration(DefaultJavaClassDeclaration clazzInfo, AnnotationTree annotationTree, TypeMirror mirror) {
        String qualifiedName = mirror.toString();

        clazzInfo.addAnnotation(new JavaAnnotation(qualifiedName));
    }

    public static void populateClassDeclaration(DefaultJavaClassDeclaration clazzInfo, ClassTree classTree, TreePath path, Trees trees) {

        TypeElement e = (TypeElement) trees.getElement(path);

        clazzInfo.setName(new QualifiedName(e.getQualifiedName().toString()));

        clazzInfo.setNestingKind(e.getNestingKind().toString());

        clazzInfo.addModifiers(e.getModifiers());

        clazzInfo.setNameOfSuperClass(e.getSuperclass().toString());

        for (TypeMirror mirror : e.getInterfaces()) {
            clazzInfo.addNameOfInterface(mirror.toString());
        }

        try {
            Class serializable = Class.forName(SERIALIZABLE_PKG);
            Class thisClass = Class.forName(e.getQualifiedName().toString());
            if (serializable.isAssignableFrom(thisClass)) {
                clazzInfo.setSerializable(true);
            } else {
                clazzInfo.setSerializable(false);
            }

        } catch (ClassNotFoundException ex) {
            clazzInfo.setSerializable(false);
        }

        List<? extends AnnotationMirror> annotations = e.getAnnotationMirrors();
        for (AnnotationMirror annotationMirror : annotations) {
            String qualifiedName = annotationMirror.toString().substring(1);
            clazzInfo.addAnnotation(new JavaAnnotation(qualifiedName));
        }

        clazzInfo.setLocationInfo(getLocationInfo(trees, path, classTree));


        DefaultJavaSourceTree treeInfo = new DefaultJavaSourceTree();
        TreePath tp = trees.getPath(e);
        treeInfo.setCompileTree(tp.getCompilationUnit());
        treeInfo.setSourcePos(trees.getSourcePositions());
        clazzInfo.setSourceTreeInfo(treeInfo);

    }

    public static void populateFieldDeclaration(DefaultJavaClassDeclaration clazzInfo, VariableTree variableTree, Element e, TreePath path, Trees trees) {
        if (e != null) {

            String fieldName = variableTree.getName().toString();
            DefaultFieldDeclaration field = new DefaultFieldDeclaration(new QualifiedName(fieldName), e.getModifiers());
            field.setOwningClass(clazzInfo);
            clazzInfo.addField(field);

            List<? extends AnnotationMirror> annotations = e.getAnnotationMirrors();
            for (AnnotationMirror annotationMirror : annotations) {
                field.addAnnotation(new JavaAnnotation(annotationMirror.toString().substring(1)));
            }

            field.setLocationInfo(getLocationInfo(trees, path, variableTree));
        }
    }

    public static void populateMethodDeclaration(DefaultJavaClassDeclaration clazzInfo, MethodTree methodTree, TreePath path, Trees trees) {

        DefaultMethodDeclaration methodInfo = new DefaultMethodDeclaration();
        String methodName = methodTree.getName().toString();
        methodInfo.setOwningClass(clazzInfo);
        //Set modifier details
        Element e = trees.getElement(path);
        //Set the param type and return path
        visitExecutable(e, methodInfo);

        methodInfo.addModifiers(e.getModifiers());

        //Check if the method is a default constructor
        if (methodName.equals(DEFAULT_CONSTRUCTOR_NAME)) {
            methodInfo.setName(clazzInfo.getName());
            clazzInfo.addConstructor(methodInfo);
        } else {
            clazzInfo.addMethod(methodInfo);
            methodInfo.setName(new QualifiedName(methodName));
        }

        LocationInfo locationInfo = getLocationInfo(trees, path, methodTree);
        methodInfo.setLocationInfo(locationInfo);
    }

    private static void visitExecutable(Element e, final DefaultMethodDeclaration methodInfo) {
        e.accept(new SimpleElementVisitor6<Object, DefaultMethodDeclaration>() {

            @Override
            public Object visitExecutable(ExecutableElement element, DefaultMethodDeclaration mInfo) {

                for (VariableElement var : element.getParameters()) {
                    methodInfo.addParameters(var.asType().toString());
                }
                methodInfo.setReturnType(element.getReturnType().toString());
                return super.visitExecutable(element, methodInfo);
            }
        }, null);
    }


    private static LocationInfo getLocationInfo(Trees trees, TreePath path, Tree tree) {

        LocationInfo locationInfo = new LocationInfo();
        SourcePositions sourcePosition = trees.getSourcePositions();
        long startPosition = sourcePosition.getStartPosition(path.getCompilationUnit(), tree);
        locationInfo.setStartOffset((int) startPosition);
        return locationInfo;
    }
}
