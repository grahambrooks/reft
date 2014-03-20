// Generated from Migration.g4 by ANTLR 4.2

    package reft.migration.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MigrationParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MigrationVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MigrationParser#qualification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualification(@NotNull MigrationParser.QualificationContext ctx);

	/**
	 * Visit a parse tree produced by {@link MigrationParser#invocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvocation(@NotNull MigrationParser.InvocationContext ctx);

	/**
	 * Visit a parse tree produced by {@link MigrationParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(@NotNull MigrationParser.QualifiedNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link MigrationParser#migrationFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMigrationFile(@NotNull MigrationParser.MigrationFileContext ctx);

	/**
	 * Visit a parse tree produced by {@link MigrationParser#migrationDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMigrationDeclaration(@NotNull MigrationParser.MigrationDeclarationContext ctx);
}