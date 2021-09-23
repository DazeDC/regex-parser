package it.unicam.cs.cmp;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import it.unicam.cs.cmp.ast.RegexAST;
import it.unicam.cs.cmp.ast.RegexASTNode;
import it.unicam.cs.cmp.parser.custom.RegexASTBuilderVisitor;
import it.unicam.cs.cmp.parser.generated.RegexLexer;
import it.unicam.cs.cmp.parser.generated.RegexParser;

public class AST {

	public static void main(String[] args) {
		CharStream regex = null;
		String inputFile = null;

		if (args.length > 0)
			inputFile = args[0];
		
		// Reads the user input as a stream of characters
		try {
			if (inputFile != null)
				regex = CharStreams.fromFileName(inputFile);
			else {
				regex = CharStreams.fromStream(System.in);
			}
		} catch (Exception e) {
			System.out.println("Invalid input file " + inputFile);
		}

		// Analyze tokens and create the parse tree
		RegexLexer lexer = new RegexLexer(regex);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		RegexParser parser = new RegexParser(tokens);
		ParseTree tree = parser.expr();

		// Create the AST root by visiting the parse tree
		RegexASTBuilderVisitor visitor = new RegexASTBuilderVisitor();
		RegexASTNode root = visitor.visit(tree);
		RegexAST ast = new RegexAST(root);
		
		System.out.println(ast);
	}

}
