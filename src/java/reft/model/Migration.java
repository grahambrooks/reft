package reft.model;

import reft.refactor.SourceChange;

import java.util.List;

public interface Migration {
    public void apply(MethodInvocation invocation, List<SourceChange> changes);
}
