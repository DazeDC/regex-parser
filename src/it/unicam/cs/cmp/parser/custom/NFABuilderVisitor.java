package it.unicam.cs.cmp.parser.custom;

import it.unicam.cs.cmp.nfa.RegexNFA;
import it.unicam.cs.cmp.nfa.builder.RegexNFABuilder;
import it.unicam.cs.cmp.parser.generated.RegexBaseVisitor;
import it.unicam.cs.cmp.parser.generated.RegexParser.ConcatKleeneContext;
import it.unicam.cs.cmp.parser.generated.RegexParser.ConcatMatchContext;
import it.unicam.cs.cmp.parser.generated.RegexParser.KleeneMatchContext;
import it.unicam.cs.cmp.parser.generated.RegexParser.KleeneTermContext;
import it.unicam.cs.cmp.parser.generated.RegexParser.TermDigitContext;
import it.unicam.cs.cmp.parser.generated.RegexParser.TermEpsilonContext;
import it.unicam.cs.cmp.parser.generated.RegexParser.TermLetterContext;
import it.unicam.cs.cmp.parser.generated.RegexParser.TermParenthesisContext;
import it.unicam.cs.cmp.parser.generated.RegexParser.UnionConcatContext;
import it.unicam.cs.cmp.parser.generated.RegexParser.UnionEOFContext;
import it.unicam.cs.cmp.parser.generated.RegexParser.UnionMatchContext;

/**
 * This class is a custom visitor which builds a {@link RegexNFA} during the visit of the parse tree.
 * 
 * It is parameterized to the type {@code T} which has to extend {@link RegexNFA}.
 * To use this class the type of {@link RegexNFA} to create must be declared and the constructor to do so
 * has to be passed.
 * 
 * @author RICCARDO
 *
 * @param <T> a concrete implementation of the {@link RegexNFA} class.
 */
public class NFABuilderVisitor<T extends RegexNFA> extends RegexBaseVisitor<T> {
	private RegexNFABuilder<T> builder = null;
	
	/**
	 * Creates an NFABuilderVisitor setting the builder to use during the visit.
	 * 
	 * The NFA builder must be one which creates instances of {@code T}.
	 * 
	 * @param builder an {@link RegexNFABuilder} which creates instances of {@code T}. 
	 */
	public NFABuilderVisitor(RegexNFABuilder<T> builder) {
		this.builder = builder;
	}
	
	/**
	 * Sets a builder for this visitor.
	 * 
	 * The NFA builder must be one which creates instances of {@code T}.
	 *  
	 */
	public void setBuilder(RegexNFABuilder<T> builder) {
		this.builder = builder;
	}


	@Override
	public T visitUnionEOF(UnionEOFContext ctx) {
		return super.visit(ctx.union());
	}



	@Override
	public T visitUnionMatch(UnionMatchContext ctx) {
		return this.builder.createFromUnion(super.visit(ctx.union()), super.visit(ctx.concat()));
	}



	@Override
	public T visitUnionConcat(UnionConcatContext ctx) {
		return super.visit(ctx.concat());
	}


	@Override
	public T visitConcatMatch(ConcatMatchContext ctx) {
		return this.builder.createFromConcatenation(super.visit(ctx.concat()), super.visit(ctx.kleene()));
	}


	@Override
	public T visitConcatKleene(ConcatKleeneContext ctx) {
		return super.visit(ctx.kleene());
	}


	@Override
	public T visitKleeneMatch(KleeneMatchContext ctx) {
		return this.builder.createFromKleene(super.visit(ctx.term()));
	}


	@Override
	public T visitKleeneTerm(KleeneTermContext ctx) {
		return super.visit(ctx.term());
	}


	@Override
	public T visitTermLetter(TermLetterContext ctx) {
		return this.builder.createFromSymbol(ctx.LETTER().getText());
	}


	@Override
	public T visitTermDigit(TermDigitContext ctx) {
		return this.builder.createFromSymbol(ctx.DIGIT().getText());
	}


	@Override
	public T visitTermEpsilon(TermEpsilonContext ctx) {
		return this.builder.createFromEpsilon();
	}


	@Override
	public T visitTermParenthesis(TermParenthesisContext ctx) {
		return super.visit(ctx.union());
	}

}
