package reft.migration;

import reft.migration.parser.MigrationParser;
import reft.model.QualifiedName;
import reft.model.predicate.MethodInvocationPredicate;
import reft.refactor.RenameMethodInvocation;

import java.util.ArrayList;

class MigrationReader {

    QualifiedName qualifiedName(MigrationParser.QualifiedNameContext context) {
        int i = 0;
        ArrayList<String> qualification = new ArrayList<>();
        while (context.prefix.Identifier(i) != null) {
            qualification.add(context.prefix.Identifier(i).getText());
            i++;
        }

        return new QualifiedName(qualification, context.name.getText());
    }

    public RenameMethodInvocation renameMethodInvocation(MigrationParser.InvocationContext invocation) {
        return new RenameMethodInvocation(new MethodInvocationPredicate(qualifiedName(invocation.predicate)), qualifiedName(invocation.newName));
    }
}
