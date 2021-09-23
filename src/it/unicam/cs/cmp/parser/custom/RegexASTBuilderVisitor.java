package it.unicam.cs.cmp.parser.custom;

import it.unicam.cs.cmp.ast.RegexASTNode;
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


public class RegexASTBuilderVisitor extends  RegexBaseVisitor<RegexASTNode>{
	
	public RegexASTBuilderVisitor() {
	}

	@Override
	public RegexASTNode visitUnionEOF(UnionEOFContext ctx) {
		return super.visit(ctx.union());
	}

	@Override
	public RegexASTNode visitUnionMatch(UnionMatchContext ctx) {
		RegexASTNode left = super.visit(ctx.union());
		RegexASTNode right = super.visit(ctx.concat());
		RegexASTNode root = new RegexASTNode(ctx.PLUS().getText());
		
		root.setLeftNode(left);
		root.setRightNode(right);
		
		return root;
	}

	@Override
	public RegexASTNode visitUnionConcat(UnionConcatContext ctx) {
		return super.visit(ctx.concat());
	}

	@Override
	public RegexASTNode visitConcatMatch(ConcatMatchContext ctx) {
		RegexASTNode left = super.visit(ctx.concat());
		RegexASTNode right = super.visit(ctx.kleene());
		RegexASTNode root = new RegexASTNode(".");
		
		root.setLeftNode(left);
		root.setRightNode(right);
		
		return root;
	}
	
	@Override
	public RegexASTNode visitConcatKleene(ConcatKleeneContext ctx) {
		return super.visit(ctx.kleene());
	}

	@Override
	public RegexASTNode visitKleeneMatch(KleeneMatchContext ctx) {
		RegexASTNode left = super.visit(ctx.term());
		RegexASTNode root = new RegexASTNode(ctx.KLEENE().getText());
		
		root.setLeftNode(left);
		
		return root;
	}

	@Override
	public RegexASTNode visitKleeneTerm(KleeneTermContext ctx) {
		return super.visit(ctx.term());
	}

	@Override
	public RegexASTNode visitTermLetter(TermLetterContext ctx) {
		return new RegexASTNode(ctx.LETTER().getText());
	}

	@Override
	public RegexASTNode visitTermDigit(TermDigitContext ctx) {
		return new RegexASTNode(ctx.DIGIT().getText());
	}

	@Override
	public RegexASTNode visitTermEpsilon(TermEpsilonContext ctx) {
		return new RegexASTNode(ctx.EPSILON().getText());
	}

	@Override
	public RegexASTNode visitTermParenthesis(TermParenthesisContext ctx) {
		return super.visit(ctx.union());
	}

	
	

}
