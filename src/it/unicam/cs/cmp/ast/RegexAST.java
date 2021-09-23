package it.unicam.cs.cmp.ast;

public class RegexAST {
	private RegexASTNode root;
	
	public RegexAST(RegexASTNode root) {
		this.root = root;
	}

	public RegexASTNode getRoot() {
		return root;
	}

	@Override
	public String toString() {
	    return this.root.toString();
	}
	
	
}
