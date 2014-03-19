package reft.refactor;

import reft.common.model.MethodInvocation;
import reft.common.model.MethodInvocationPredicate;

import java.util.ArrayList;

public class RenameMethodInvocation {
    private MethodInvocationPredicate predicate;
    private String newName;

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
