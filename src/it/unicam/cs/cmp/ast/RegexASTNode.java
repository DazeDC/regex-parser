package it.unicam.cs.cmp.ast;

public class RegexASTNode {
	// term string
	private String regexTerm;

	private RegexASTNode leftNode = null;
	private RegexASTNode rightNode = null;
	
	public RegexASTNode(String regexTerm) {
		this.regexTerm = regexTerm;
	}

	public RegexASTNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(RegexASTNode leftNode) {
		this.leftNode = leftNode;
	}

	public RegexASTNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(RegexASTNode rightNode) {
		this.rightNode = rightNode;
	}

	public String getRegexTerm() {
		return regexTerm;
	}
	
	public boolean hasChildren() {
		return (this.leftNode != null || this.rightNode != null) ? true : false;
	}
	
	public StringBuilder toString(StringBuilder prefix, boolean isRoot, boolean isTail, StringBuilder sb) {
	    if(this.rightNode != null) {
	    	this.rightNode.toString(new StringBuilder().append(prefix).append(isTail ? "|   " : "    "), false, false, sb);
	    }
	    if(isRoot)
	    	sb.append(prefix).append("-  ").append(this.getRegexTerm().toString()).append("\n");
	    else
	    	sb.append(prefix).append(isTail ? "|__  " : "|--- ").append(this.getRegexTerm().toString()).append("\n");
	    if(this.leftNode != null) {
	        this.leftNode.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "|   "), false, true, sb);
	    }
	    return sb;
	}
	
	@Override
	public String toString() {
	    return this.toString(new StringBuilder(), true, true, new StringBuilder()).toString();
	}

}
