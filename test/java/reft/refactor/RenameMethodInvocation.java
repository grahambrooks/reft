package reft.refactor;

import reft.model.MethodInvocation;
import reft.model.predicate.MethodInvocationPredicate;

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
