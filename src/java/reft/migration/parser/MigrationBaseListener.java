// Generated from Migration.g4 by ANTLR 4.0

    package reft.migration.parser;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class MigrationBaseListener implements MigrationListener {
	@Override public void enterRenameMigration(MigrationParser.RenameMigrationContext ctx) { }
	@Override public void exitRenameMigration(MigrationParser.RenameMigrationContext ctx) { }

	@Override public void enterQualifiedName(MigrationParser.QualifiedNameContext ctx) { }
	@Override public void exitQualifiedName(MigrationParser.QualifiedNameContext ctx) { }

	@Override public void enterMigrationFile(MigrationParser.MigrationFileContext ctx) { }
	@Override public void exitMigrationFile(MigrationParser.MigrationFileContext ctx) { }

	@Override public void enterMigrationDeclaration(MigrationParser.MigrationDeclarationContext ctx) { }
	@Override public void exitMigrationDeclaration(MigrationParser.MigrationDeclarationContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}