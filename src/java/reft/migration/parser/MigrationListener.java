// Generated from Migration.g4 by ANTLR 4.2

    package reft.migration.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MigrationParser}.
 */
public interface MigrationListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MigrationParser#qualification}.
	 * @param ctx the parse tree
	 */
	void enterQualification(@NotNull MigrationParser.QualificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MigrationParser#qualification}.
	 * @param ctx the parse tree
	 */
	void exitQualification(@NotNull MigrationParser.QualificationContext ctx);

	/**
	 * Enter a parse tree produced by {@link MigrationParser#invocation}.
	 * @param ctx the parse tree
	 */
	void enterInvocation(@NotNull MigrationParser.InvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MigrationParser#invocation}.
	 * @param ctx the parse tree
	 */
	void exitInvocation(@NotNull MigrationParser.InvocationContext ctx);

	/**
	 * Enter a parse tree produced by {@link MigrationParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(@NotNull MigrationParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MigrationParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(@NotNull MigrationParser.QualifiedNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link MigrationParser#migrationFile}.
	 * @param ctx the parse tree
	 */
	void enterMigrationFile(@NotNull MigrationParser.MigrationFileContext ctx);
	/**
	 * Exit a parse tree produced by {@link MigrationParser#migrationFile}.
	 * @param ctx the parse tree
	 */
	void exitMigrationFile(@NotNull MigrationParser.MigrationFileContext ctx);

	/**
	 * Enter a parse tree produced by {@link MigrationParser#migrationDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMigrationDeclaration(@NotNull MigrationParser.MigrationDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MigrationParser#migrationDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMigrationDeclaration(@NotNull MigrationParser.MigrationDeclarationContext ctx);
}