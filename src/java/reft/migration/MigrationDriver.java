package reft.migration;

import reft.model.MethodInvocation;
import reft.model.Migration;
import reft.refactor.RenameMethodInvocation;
import reft.refactor.SourceChange;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.googlecode.totallylazy.Sequences.sequence;

public class MigrationDriver {
    private Collection<RenameMethodInvocation> renameMethods = new ArrayList<>();
    private Collection<Migration> migrations;
    private List<SourceChange> changes;

    public MigrationDriver(Collection<Migration> migrations, java.util.List<SourceChange> changes) {
        this.migrations = migrations;
        sequence(migrations).foldLeft(renameMethods, (s, m) -> {
            if (m instanceof RenameMethodInvocation) s.add((RenameMethodInvocation) m);
            return s;
        });
        this.changes = changes;
    }

    public void apply(MethodInvocation methodInvocation) {
        for (RenameMethodInvocation rename : renameMethods) {
            rename.apply(methodInvocation, changes);
        }

    }
}
