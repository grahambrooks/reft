package reft.common;

import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.util.List;
import reft.common.model.ClassModelMap;
import reft.common.model.Location;
import reft.common.model.MethodInvocation;
import reft.common.model.MethodInvocationPredicate;

import java.util.ArrayList;
import java.util.Collection;

import static com.googlecode.totallylazy.Sequences.sequence;

public class MigrationDriver {
    ClassModelMap model;
    Collection<MethodInvocationPredicate> methodInvocationPredicates = new ArrayList<>();

    public MigrationDriver(ClassModelMap model) {
        this.model = model;
    }

    public void methodInvocation(QualifiedName methodName, Location nameLocation, List<Symbol.VarSymbol> parameters) {
        new MethodInvocation(methodName, nameLocation, sequence(parameters).foldLeft(new ArrayList<>(), (list, vs) -> {
            list.add(vs.asType().toString());
            return list;
        }));
        System.out.println("Method invocation: " + methodName);

        for (Symbol.VarSymbol sym : parameters) {
            System.out.println(sym.asType());
        }
    }

    public void apply(MethodInvocation methodInvocation) {
        for (MethodInvocationPredicate predicate : methodInvocationPredicates) {
            if (predicate.matches(methodInvocation)) {

            }
        }

    }
}
