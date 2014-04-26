package reft.migration;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;
import reft.migration.parser.MigrationLexer;
import reft.migration.parser.MigrationParser;
import reft.model.Migration;
import reft.model.QualifiedName;
import reft.refactor.RenameMethodInvocation;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MigrationReaderTests {
    @Test
    public void readsSimpleCallMigration() throws UnsupportedEncodingException {
        String input = "migration someAwesomeMethod() -> someMoreAwesomeMethod();";

        MigrationReader reader = new MigrationReader();

        Collection<Migration> migrations = reader.readMigrations(new ByteArrayInputStream(input.getBytes("UTF-8")));

        assertThat(migrations.size(), is(1));
        Migration migration = migrations.iterator().next();
        assertThat(migration, isA((Class) RenameMethodInvocation.class));

    }

    @Test
    public void readsQualifiedNames() {
        String input = "a.b.c";
        MigrationParser parser = makeParser(input);
        MigrationParser.QualifiedNameContext qualifiedNameContext = parser.qualifiedName();

        MigrationReader reader = new MigrationReader();
        QualifiedName qualifiedName = reader.qualifiedName(qualifiedNameContext);

        assertThat(qualifiedName.getName(), is("c"));
    }

    @Test
    public void readsSimpleNames() {
        String input = "a";
        MigrationParser parser = makeParser(input);
        MigrationParser.QualifiedNameContext qualifiedNameContext = parser.qualifiedName();

        MigrationReader reader = new MigrationReader();
        QualifiedName qualifiedName = reader.qualifiedName(qualifiedNameContext);

        assertThat(qualifiedName.getName(), is("a"));
    }

    @Test
    public void readsInvocationRenames() {
        String input = "a() -> b()";
        MigrationParser parser = makeParser(input);
        MigrationParser.InvocationContext invocation = parser.invocation();

        MigrationReader reader = new MigrationReader();
        RenameMethodInvocation refactor = reader.renameMethodInvocation(invocation);

        assertThat(refactor.getPredicate().toString(), is("a()"));
        assertThat(refactor.getReplacement().toString(), is("b"));

    }

    private MigrationParser makeParser(String input) {
        ANTLRInputStream in = new ANTLRInputStream(input);
        MigrationLexer lexer = new MigrationLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new MigrationParser(tokens);
    }

}
