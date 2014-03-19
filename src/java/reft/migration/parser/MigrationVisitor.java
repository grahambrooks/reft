// Generated from Migration.g4 by ANTLR 4.0

    package reft.migration.parser;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface MigrationVisitor<T> extends ParseTreeVisitor<T> {
	T visitRenameMigration(MigrationParser.RenameMigrationContext ctx);

	T visitQualifiedName(MigrationParser.QualifiedNameContext ctx);

	T visitMigrationFile(MigrationParser.MigrationFileContext ctx);

	T visitMigrationDeclaration(MigrationParser.MigrationDeclarationContext ctx);
}