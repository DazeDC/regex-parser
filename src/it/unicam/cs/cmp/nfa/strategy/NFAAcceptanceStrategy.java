package it.unicam.cs.cmp.nfa.strategy;

import it.unicam.cs.cmp.nfa.RegexNFA;

/**
 * This interface is a common base for all the acceptance algorithms.
 * 
 * @author RICCARDO
 *
 */
public interface NFAAcceptanceStrategy {
	
	/**
	 * This method performs an acceptance algorithm on a string using the given NFA.
	 * 
	 * @param s the {@linkplain String} to check.
	 * @param nfa the {@link RegexNFA} to use.
	 * @return {@code true} if the string is accepted by the nfa, {@code false} otherwise.
	 */
	public boolean accept(String s, RegexNFA nfa);
}
