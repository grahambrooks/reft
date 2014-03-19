// Generated from Migration.g4 by ANTLR 4.0

    package reft.migration.parser;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface MigrationListener extends ParseTreeListener {
	void enterRenameMigration(MigrationParser.RenameMigrationContext ctx);
	void exitRenameMigration(MigrationParser.RenameMigrationContext ctx);

	void enterQualifiedName(MigrationParser.QualifiedNameContext ctx);
	void exitQualifiedName(MigrationParser.QualifiedNameContext ctx);

	void enterMigrationFile(MigrationParser.MigrationFileContext ctx);
	void exitMigrationFile(MigrationParser.MigrationFileContext ctx);

	void enterMigrationDeclaration(MigrationParser.MigrationDeclarationContext ctx);
	void exitMigrationDeclaration(MigrationParser.MigrationDeclarationContext ctx);
}