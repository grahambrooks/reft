package reft.refactor;

import reft.model.MethodInvocation;
import reft.model.predicate.MethodInvocationPredicate;

import java.util.ArrayList;

class RenameMethodInvocation {
    private final MethodInvocationPredicate predicate;
    private final String newName;

    public RenameMethodInvocation(MethodInvocationPredicate predicate, String newName) {

        this.predicate = predicate;
        this.newName = newName;
    }

    public void apply(MethodInvocation invocation, ArrayList<SourceChange> changes) {
        if (predicate.matches(invocation)) {
            changes.add(new ReplaceSourceChange(invocation.getNameLocation(), newName));
        }
    }
}
