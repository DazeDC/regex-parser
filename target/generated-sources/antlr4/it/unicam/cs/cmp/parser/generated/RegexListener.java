// Generated from Regex.g4 by ANTLR 4.9.2

   package it.unicam.cs.cmp.parser.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RegexParser}.
 */
public interface RegexListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code unionEOF}
	 * labeled alternative in {@link RegexParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnionEOF(RegexParser.UnionEOFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unionEOF}
	 * labeled alternative in {@link RegexParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnionEOF(RegexParser.UnionEOFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unionMatch}
	 * labeled alternative in {@link RegexParser#union}.
	 * @param ctx the parse tree
	 */
	void enterUnionMatch(RegexParser.UnionMatchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unionMatch}
	 * labeled alternative in {@link RegexParser#union}.
	 * @param ctx the parse tree
	 */
	void exitUnionMatch(RegexParser.UnionMatchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unionConcat}
	 * labeled alternative in {@link RegexParser#union}.
	 * @param ctx the parse tree
	 */
	void enterUnionConcat(RegexParser.UnionConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unionConcat}
	 * labeled alternative in {@link RegexParser#union}.
	 * @param ctx the parse tree
	 */
	void exitUnionConcat(RegexParser.UnionConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code concatKleene}
	 * labeled alternative in {@link RegexParser#concat}.
	 * @param ctx the parse tree
	 */
	void enterConcatKleene(RegexParser.ConcatKleeneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code concatKleene}
	 * labeled alternative in {@link RegexParser#concat}.
	 * @param ctx the parse tree
	 */
	void exitConcatKleene(RegexParser.ConcatKleeneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code concatMatch}
	 * labeled alternative in {@link RegexParser#concat}.
	 * @param ctx the parse tree
	 */
	void enterConcatMatch(RegexParser.ConcatMatchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code concatMatch}
	 * labeled alternative in {@link RegexParser#concat}.
	 * @param ctx the parse tree
	 */
	void exitConcatMatch(RegexParser.ConcatMatchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code kleeneMatch}
	 * labeled alternative in {@link RegexParser#kleene}.
	 * @param ctx the parse tree
	 */
	void enterKleeneMatch(RegexParser.KleeneMatchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code kleeneMatch}
	 * labeled alternative in {@link RegexParser#kleene}.
	 * @param ctx the parse tree
	 */
	void exitKleeneMatch(RegexParser.KleeneMatchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code kleeneTerm}
	 * labeled alternative in {@link RegexParser#kleene}.
	 * @param ctx the parse tree
	 */
	void enterKleeneTerm(RegexParser.KleeneTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code kleeneTerm}
	 * labeled alternative in {@link RegexParser#kleene}.
	 * @param ctx the parse tree
	 */
	void exitKleeneTerm(RegexParser.KleeneTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termLetter}
	 * labeled alternative in {@link RegexParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermLetter(RegexParser.TermLetterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termLetter}
	 * labeled alternative in {@link RegexParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermLetter(RegexParser.TermLetterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termDigit}
	 * labeled alternative in {@link RegexParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermDigit(RegexParser.TermDigitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termDigit}
	 * labeled alternative in {@link RegexParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermDigit(RegexParser.TermDigitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termEpsilon}
	 * labeled alternative in {@link RegexParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermEpsilon(RegexParser.TermEpsilonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termEpsilon}
	 * labeled alternative in {@link RegexParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermEpsilon(RegexParser.TermEpsilonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termParenthesis}
	 * labeled alternative in {@link RegexParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTermParenthesis(RegexParser.TermParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termParenthesis}
	 * labeled alternative in {@link RegexParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTermParenthesis(RegexParser.TermParenthesisContext ctx);
}