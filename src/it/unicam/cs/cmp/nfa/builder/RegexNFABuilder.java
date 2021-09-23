package it.unicam.cs.cmp.nfa.builder;

import it.unicam.cs.cmp.nfa.RegexNFA;

/**
 * This interface declares the methods that create an NFA applying one of the six
 * general rules.
 * 
 * Each method create a different NFA based on the rule to apply.
 * 
 * @author RICCARDO
 *
 * @param <T> a concrete implementation of {@link RegexNFA}.
 */
public interface RegexNFABuilder<T extends RegexNFA> {
	
	/**
	 * Creates an empty NFA. 
	 */
	public T createEmpty();

	/**
	 * Creates an NFA derived from the epsilon symbol.
	 */
	public T createFromEpsilon();

	/**
	 * Creates an NFA derived from an alphabet symbol.
	 * 
	 * @param s the symbol character.
	 */
	public T createFromSymbol(String s);

	/**
	 * Creates an NFA derived from the union of two NFAs.
	 */
	public T createFromUnion(T firstNFA, T secondNFA);

	/**
	 * Creates an NFA derived from the concatenation of two NFAs.
	 */
	public T createFromConcatenation(T firstNFA, T secondNFA);

	/**
	 * Creates an NFA derived from the kleene star applied to an NFA.
	 */
	public T createFromKleene(T nfa);

}
