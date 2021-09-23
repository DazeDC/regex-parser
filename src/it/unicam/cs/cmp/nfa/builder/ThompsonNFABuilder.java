package it.unicam.cs.cmp.nfa.builder;

import java.util.Set;

import it.unicam.cs.cmp.nfa.NFAState;
import it.unicam.cs.cmp.nfa.NFATransition;
import it.unicam.cs.cmp.nfa.ThompsonNFA;

/**
 * This class applies the rules of the Thompson Construction Algorithm.
 * 
 * @author RICCARDO
 *
 */
public class ThompsonNFABuilder implements RegexNFABuilder<ThompsonNFA> {
	
	// keeps track of next the state id
	private Integer idCounter = 0;
	
	private final String EPSILONSYMBOL = "";

	/**
	 * {@inheritDoc}
	 * @return a {@link ThompsonNFA}.
	 */
	@Override
	public ThompsonNFA createEmpty() {
		return new ThompsonNFA();
	}
	
	/**
	 * {@inheritDoc}
	 * @return a {@link ThompsonNFA}.
	 */
	@Override
	public ThompsonNFA createFromEpsilon() {
		ThompsonNFA nfa = new ThompsonNFA();
		
		nfa.addTransition(EPSILONSYMBOL, new NFAState(idCounter++, true), new NFAState(idCounter++, false));

		return nfa;
	}

	/**
	 * {@inheritDoc}
	 * @return a {@link ThompsonNFA}.
	 */
	@Override
	public ThompsonNFA createFromSymbol(String s) {
		ThompsonNFA nfa = new ThompsonNFA();

		nfa.addTransition(s, new NFAState(idCounter++, true), new NFAState(idCounter++, false));

		return nfa;
	}

	/**
	 * {@inheritDoc}
	 * @param firstNFA a {@link ThompsonNFA}.
	 * @param secondNFA a {@link ThompsonNFA}.
	 * @return a {@link ThompsonNFA}.
	 */
	@Override
	public ThompsonNFA createFromUnion(ThompsonNFA firstNFA, ThompsonNFA secondNFA) {
		ThompsonNFA newNfa = new ThompsonNFA();
		
		NFAState newInitial = new NFAState(idCounter++, true);
		NFAState newFinal = new NFAState(idCounter++, false);
		
		firstNFA.getInitialState().setInitial(false);
		secondNFA.getInitialState().setInitial(false);
		
		firstNFA.getFinalState().setFinal(false);
		secondNFA.getFinalState().setFinal(false);
		
		newNfa.addTransition(EPSILONSYMBOL, newInitial, firstNFA.getInitialState());
		newNfa.addTransition(EPSILONSYMBOL, newInitial, secondNFA.getInitialState());
		
		newNfa.addTransition(EPSILONSYMBOL, firstNFA.getFinalState(), newFinal);
		newNfa.addTransition(EPSILONSYMBOL, secondNFA.getFinalState(), newFinal);
		
		newNfa.addTransitions(firstNFA.getTransitions());
		newNfa.addTransitions(secondNFA.getTransitions());
		
		return newNfa;
	}

	/**
	 * {@inheritDoc}
	 * @param firstNFA a {@link ThompsonNFA}.
	 * @param secondNFA a {@link ThompsonNFA}.
	 * @return a {@link ThompsonNFA}.
	 */
	@Override
	public ThompsonNFA createFromConcatenation(ThompsonNFA firstNFA, ThompsonNFA secondNFA) {
		NFAState firstFinal = firstNFA.getFinalState();
		NFAState secondInitial = secondNFA.getInitialState();
		
		firstFinal.setFinal(false);
		
		Set<NFATransition> initSecondOutgoingTransitions = secondInitial.getOutgoingTransitions();
		
		for (NFATransition transition : initSecondOutgoingTransitions) {
			transition.setSource(firstFinal);
			firstFinal.addTransition(transition);
		}
		
		secondNFA.deleteState(secondInitial);
		
		ThompsonNFA newNfa = new ThompsonNFA();

		newNfa.addTransitions(firstNFA.getTransitions());
		newNfa.addTransitions(secondNFA.getTransitions());
		
		return newNfa;
	}

	/**
	 * {@inheritDoc}
	 * @param nfa a {@link ThompsonNFA}.
	 * @return a {@link ThompsonNFA}.
	 */
	@Override
	public ThompsonNFA createFromKleene(ThompsonNFA nfa) {
		ThompsonNFA newNfa = new ThompsonNFA();

		NFAState newInitial = new NFAState(idCounter++, true);
		NFAState newFinal = new NFAState(idCounter++, false);

		nfa.getInitialState().setInitial(false);
		nfa.getFinalState().setFinal(false);
		
		newNfa.addTransition(EPSILONSYMBOL, newInitial, nfa.getInitialState());
		newNfa.addTransition(EPSILONSYMBOL, newInitial, newFinal);
		newNfa.addTransition(EPSILONSYMBOL, nfa.getFinalState(), newFinal);
		newNfa.addTransition(EPSILONSYMBOL, nfa.getFinalState(), nfa.getInitialState());
		
		newNfa.addTransitions(nfa.getTransitions());		
		
		return newNfa;
	}

}
