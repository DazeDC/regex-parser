package it.unicam.cs.cmp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import it.unicam.cs.cmp.nfa.RegexNFA;
import it.unicam.cs.cmp.nfa.ThompsonNFA;
import it.unicam.cs.cmp.nfa.builder.ThompsonNFABuilder;
import it.unicam.cs.cmp.parser.custom.NFABuilderVisitor;
import it.unicam.cs.cmp.parser.generated.RegexLexer;
import it.unicam.cs.cmp.parser.generated.RegexParser;

public class Regex {

	public static void main(String[] args) {
		CharStream regex = null;
		String inputFile = null;
		List<String> toEvalStrings = null;

		if (args.length > 0)
			inputFile = args[0];
		
		// Reads the user input as a stream of characters
		try {
			CharStream userInput;
			if (inputFile != null)
				userInput = CharStreams.fromFileName(inputFile);
			else {
				userInput = CharStreams.fromStream(System.in);
			}

			// extract the regex and the strings to check from the user input
			toEvalStrings = Arrays.asList(userInput.toString().split(","));
			regex = CharStreams.fromString(toEvalStrings.get(0));
			toEvalStrings = toEvalStrings.subList(1, toEvalStrings.size());
			toEvalStrings.replaceAll(String::trim);
		} catch (Exception e) {
			System.out.println("Invalid input file " + inputFile);
		}

		if(toEvalStrings.isEmpty()) {
			System.out.println("There is no string to check.");
			return;
		}
		
		// Analyze tokens and create the parse tree
		RegexLexer lexer = new RegexLexer(regex);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		RegexParser parser = new RegexParser(tokens);
		ParseTree tree = parser.expr();

		// Create the NFA by visiting the parse tree
		NFABuilderVisitor<ThompsonNFA> visitor = new NFABuilderVisitor<ThompsonNFA>(new ThompsonNFABuilder());
		RegexNFA nfa = visitor.visit(tree);
		System.out.println(nfa);
		// check in parallel the acceptance of each string and replace it with OK if its true, otherwise KO
		toEvalStrings = toEvalStrings.parallelStream()
									 .map(nfa::accept)
									 .map(res -> (res) ? "OK" : "KO")
									 .collect(Collectors.toList());


		/*Just a pretty print (it excludes external square parenthesis)*/
		String toPrint = toEvalStrings.toString();
		System.out.println(toPrint.substring(1, toPrint.length()-1));
	}

}
