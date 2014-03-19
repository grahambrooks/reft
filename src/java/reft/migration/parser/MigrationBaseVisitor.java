// Generated from Migration.g4 by ANTLR 4.0

package reft.migration.parser;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class MigrationBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements MigrationVisitor<T> {
    @Override
    public T visitRenameMigration(MigrationParser.RenameMigrationContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitQualifiedName(MigrationParser.QualifiedNameContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitMigrationFile(MigrationParser.MigrationFileContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitMigrationDeclaration(MigrationParser.MigrationDeclarationContext ctx) {
        return visitChildren(ctx);
    }
}