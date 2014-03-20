package reft.refactor;

import com.sun.org.apache.bcel.internal.classfile.StackMapType;
import reft.model.MethodInvocation;
import reft.model.QualifiedName;
import reft.model.predicate.MethodInvocationPredicate;

import java.util.ArrayList;

public class RenameMethodInvocation {
    private final MethodInvocationPredicate predicate;
    private final QualifiedName newName;

    public RenameMethodInvocation(MethodInvocationPredicate predicate, QualifiedName newName) {

        this.predicate = predicate;
        this.newName = newName;
    }

    public void apply(MethodInvocation invocation, ArrayList<ReplaceSourceChange> changes) {
        if (predicate.matches(invocation)) {
            changes.add(new ReplaceSourceChange(invocation.getNameLocation(), newName.toString()));
        }
    }

    public MethodInvocationPredicate getPredicate() {
        return predicate;
    }

    public QualifiedName getReplacement() {
        return newName;
    }
}
