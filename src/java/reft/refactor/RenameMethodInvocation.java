package reft.refactor;

import reft.model.MethodInvocation;
import reft.model.Migration;
import reft.model.QualifiedName;
import reft.model.predicate.MethodInvocationPredicate;

import java.util.ArrayList;
import java.util.List;

public class RenameMethodInvocation implements Migration {
    private final MethodInvocationPredicate predicate;
    private final QualifiedName newName;

    public RenameMethodInvocation(MethodInvocationPredicate predicate, QualifiedName newName) {

        this.predicate = predicate;
        this.newName = newName;
    }

    public void apply(MethodInvocation invocation, List<SourceChange> changes) {
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
