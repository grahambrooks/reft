package reft.migration;

import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.util.List;
import reft.model.Location;
import reft.model.MethodInvocation;
import reft.model.QualifiedName;
import reft.model.predicate.MethodInvocationPredicate;

import java.util.ArrayList;
import java.util.Collection;

import static com.googlecode.totallylazy.Sequences.sequence;

public class MigrationDriver {
    private Collection<MethodInvocationPredicate> methodInvocationPredicates = new ArrayList<>();

    public MigrationDriver() {
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
