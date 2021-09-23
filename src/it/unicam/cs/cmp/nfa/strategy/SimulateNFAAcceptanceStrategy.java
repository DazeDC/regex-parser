package it.unicam.cs.cmp.nfa.strategy;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import it.unicam.cs.cmp.nfa.NFAState;
import it.unicam.cs.cmp.nfa.NFATransition;
import it.unicam.cs.cmp.nfa.RegexNFA;

/**
 * This class performs the acceptance of a string by an NFA using
 * the simulation algorithm.
 * 
 * @author RICCARDO
 *
 */
public class SimulateNFAAcceptanceStrategy implements NFAAcceptanceStrategy {
	
	/**
	 * This method retrieves all the states that can be reached from the given one
	 * with a transition labelled with the given symbol.
	 * 
	 * @param state the {@link NFAState} from where to start. 
	 * @param symbol the label of the wanted transitions.
	 * @return a {@link Set} of {@link NFAState} representing the reached states.
	 */
	private Set<NFAState> move(NFAState state, String symbol) {
		Set<NFATransition> outTransitions = state.getOutgoingTransitions();
		
		if(outTransitions.isEmpty())
			return new HashSet<>();
		
		Set<NFAState> nextStates = outTransitions.parallelStream()
												 .filter(trans -> trans.getSymbol().equals(symbol))
												 .map(NFATransition::getDestination)
												 .collect(Collectors.toSet());
		
		return nextStates;
	}
	
	/**
	 * This method retrieves all the states that can be reached from any of the given ones
	 * with a transition labelled with the given symbol.
	 *
	 * @param states a {@link Set} of {@link NFAState} from where to start. 
	 * @param symbol the label of the wanted transitions.
	 * @return a {@link Set} of {@link NFAState} representing the reached states.
	 */
	private Set<NFAState> move(Set<NFAState> states, String symbol) {
		Set<NFAState> nextStates = new HashSet<>();
		
		states.parallelStream().forEach(state -> nextStates.addAll(this.move(state, symbol)));
		
		return nextStates;
	}
	
	/**
	 * This method retrieves all the states that are reachable from the given one by
	 * only consuming epsilon transitions.
	 * 
	 * @param state the {@link NFAState} from where to start.
	 * @return a {@link Set} of {@link NFAState} representing the reached states.
	 */
	private Set<NFAState> eClosure(NFAState state) {
		Deque<NFAState> statesStack = new LinkedList<>();
		
		statesStack.add(state);
		
		Set<NFAState> eStates = new HashSet<>(statesStack);
		
		while (!statesStack.isEmpty()) {
			NFAState currentState = statesStack.pop();
			Set<NFAState> nextEStates = this.move(currentState, "");
			
			if(nextEStates.isEmpty())
				continue;
			
			statesStack.addAll(nextEStates.parallelStream()
										  .filter(Predicate.not(eStates::contains))
										  .collect(Collectors.toList())
							  );
			
			eStates.addAll(nextEStates);
		}
		return eStates;
	}
	
	/**
	 * This method retrieves all the states that are reachable from any of the given ones by
	 * only consuming epsilon transitions.
	 * 
	 * @param states a {@link Set} of {@link NFAState} from where to start.
	 * @return a {@link Set} of {@link NFAState} representing the reached states.
	 */
	private Set<NFAState> eClosure(Set<NFAState> states) {
		Set<NFAState> eOut = new HashSet<>();
		
		states.parallelStream().forEach(state -> eOut.addAll(this.eClosure(state)));
		
		return eOut;
	}
	
	/**
	 * This method simulates the given NFA to check the acceptance of a string.
	 */
	@Override
	public boolean accept(String s, RegexNFA nfa) {
		Set<NFAState> currentStates = new HashSet<NFAState>();
		
		List<Character> chars = s.chars().mapToObj(c -> (char)c).collect(Collectors.toList());

		currentStates = this.eClosure(nfa.getInitialState());
		
		for (Character symbol : chars) {
			currentStates = this.eClosure(this.move(currentStates, symbol.toString()));
		}

		return currentStates.parallelStream().anyMatch(nfa.getFinalState()::equals);
	}

}
