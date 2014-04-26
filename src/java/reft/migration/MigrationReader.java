package reft.migration;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import reft.migration.parser.MigrationBaseVisitor;
import reft.migration.parser.MigrationLexer;
import reft.migration.parser.MigrationParser;
import reft.model.Migration;
import reft.model.QualifiedName;
import reft.model.predicate.MethodInvocationPredicate;
import reft.refactor.RenameMethodInvocation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MigrationReader {

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

    public Collection<Migration> readMigrations(InputStream inputStream) {
        List<Migration> migrations = new ArrayList<>();
        MigrationParser parser = makeParser(inputStream);

        MigrationBaseVisitor visitor = new MigrationBaseVisitor() {
            @Override
            public Object visitInvocation(@NotNull MigrationParser.InvocationContext ctx) {
                migrations.add(renameMethodInvocation(ctx));
                return super.visitInvocation(ctx);
            }
        };

        visitor.visit(parser.migrationFile());

        return migrations;
    }


    private MigrationParser makeParser(InputStream input) {
        try {
            ANTLRInputStream in = new ANTLRInputStream(input);
            MigrationLexer lexer = new MigrationLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            return new MigrationParser(tokens);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
