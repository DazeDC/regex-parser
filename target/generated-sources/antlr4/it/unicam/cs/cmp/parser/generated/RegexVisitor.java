// Generated from Regex.g4 by ANTLR 4.9.2

   package it.unicam.cs.cmp.parser.generated;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RegexParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RegexVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code unionEOF}
	 * labeled alternative in {@link RegexParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionEOF(RegexParser.UnionEOFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unionMatch}
	 * labeled alternative in {@link RegexParser#union}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionMatch(RegexParser.UnionMatchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unionConcat}
	 * labeled alternative in {@link RegexParser#union}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionConcat(RegexParser.UnionConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code concatKleene}
	 * labeled alternative in {@link RegexParser#concat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatKleene(RegexParser.ConcatKleeneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code concatMatch}
	 * labeled alternative in {@link RegexParser#concat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatMatch(RegexParser.ConcatMatchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code kleeneMatch}
	 * labeled alternative in {@link RegexParser#kleene}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKleeneMatch(RegexParser.KleeneMatchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code kleeneTerm}
	 * labeled alternative in {@link RegexParser#kleene}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKleeneTerm(RegexParser.KleeneTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code termLetter}
	 * labeled alternative in {@link RegexParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermLetter(RegexParser.TermLetterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code termDigit}
	 * labeled alternative in {@link RegexParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermDigit(RegexParser.TermDigitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code termEpsilon}
	 * labeled alternative in {@link RegexParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermEpsilon(RegexParser.TermEpsilonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code termParenthesis}
	 * labeled alternative in {@link RegexParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermParenthesis(RegexParser.TermParenthesisContext ctx);
}