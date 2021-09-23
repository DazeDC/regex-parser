package it.unicam.cs.cmp.nfa;

import java.util.HashSet;
import java.util.Set;

import it.unicam.cs.cmp.nfa.builder.RegexNFABuilder;
import it.unicam.cs.cmp.nfa.strategy.SimulateNFAAcceptanceStrategy;
import it.unicam.cs.cmp.nfa.strategy.NFAAcceptanceStrategy;

/**
 * This class implements a generic NFA which represents a Regular Expression.<br><br>
 * 
 * It defines all the general methods to add, retrieve and delete states and transitions.<br><br>
 * 
 * This class also implements a method to check whether a string is accepted by this NFA.
 * The algorithm used to compute the acceptance can be set, otherwise a common algorithm is used, 
 * the latter is implemented as a {@link SimulateNFAAcceptanceStrategy}.<br><br>
 * 
 * An NFA representing a regular expression can be constructed in many ways, leading to specific
 * automata depending on the construction algorithm that has been used.<br>
 * For example the {@link ThompsonNFA} is an NFA constructed through the Thompson's algorithm.<br><br>
 * 
 * In order to express different representations you may implement a new NFA extending this one, and
 * create the actual {@link RegexNFABuilder}. 
 * 
 * @author RICCARDO
 *
 */
public abstract class RegexNFA {
	private Set<NFAState> states = new HashSet<NFAState>();
	
	private Set<NFATransition> transitions = new HashSet<NFATransition>();

	private NFAState initialState;
	
	private NFAState finalState;
	
	private NFAAcceptanceStrategy acceptanceStrategy = new SimulateNFAAcceptanceStrategy();
	

	/**
	 * Checks whether the NFA accept the given string.
	 * 
	 * @param s the {@link String} to check.
	 * @return True if the string is accepted, false otherwise.
	 */
	public boolean accept(String s) {
		return this.acceptanceStrategy.accept(s, this);
	}


	/**
	 * Sets the strategy (algorithm) used to check the acceptance of a string.
	 * 
	 * @param acceptanceStrategy an implemented {@link NFAAcceptanceStrategy}
	 */
	public void setAcceptanceStrategy(NFAAcceptanceStrategy acceptanceStrategy) {
		this.acceptanceStrategy = acceptanceStrategy;
	}

	
	/**
	 * Removes a state from the NFA and all its associated transitions.
	 * 
	 * If it was whether an initial or a final state the corresponding fields are
	 * set to null.
	 * 
	 * @param state state the {@link NFAState} to delete.
	 */
	public void deleteState(NFAState state) {
		this.states.remove(state);
		
		if(state.isInitial())
			this.initialState = null;
		
		if(state.isFinal())
			this.finalState = null;
		
		this.transitions.removeAll(state.getOutgoingTransitions());
	}
	

	/**
	 * Creates and adds a transition to the NFA.
	 * 
	 * If one of the given states are not in the NFA they are added.
	 * If the source state is labelled as initial it will be set as initial
	 * for the NFA only if there is no other initial state already set.
	 * Same for the destination state which, on the other hand, will be set as final.
	 * 
	 * @param symbol the symbol to associate to the transition.
	 * @param sourceState the {@link NFAState} to associate to the transition source.
	 * @param destinationState the {@link NFAState} to associate to the transition destination.
	 */
	public void addTransition(String symbol, NFAState sourceState, NFAState destinationState) {
		this.states.add(sourceState);
		this.states.add(destinationState);
		
		NFATransition transition = new NFATransition(symbol, sourceState, destinationState);

		this.transitions.add(transition);
		sourceState.addTransition(transition);
		
		if(this.initialState == null && sourceState.isInitial())
			this.initialState = sourceState;
		
		if(this.finalState == null && destinationState.isFinal())
			this.finalState = destinationState;
		
	}
	
	
	/**
	 * Adds a set of already created transitions to the NFA.
	 * 
	 * If one of the states in the transitions are not in the NFA they are added.
	 * If a source state is labelled as initial it will be set as initial
	 * for the NFA only if there is no other initial state already set.
	 * Same for the destination state which, on the other hand, will be set as final.
	 * 
	 * @param transitions the already created {@link NFATransition} to add.
	 */
	public void addTransitions(Set<NFATransition> transitions) {
		for (NFATransition regexNFATransition : transitions) {
			this.addTransition(regexNFATransition.getSymbol(), regexNFATransition.getSource(), regexNFATransition.getDestination());
		}
	}
	

	/**
	 * Gets all the transitions in the NFA.
	 * 
	 * @return a {@link Set} of {@link NFATransition}.
	 */
	public Set<NFATransition> getTransitions() {
		return transitions;
	}

	/**
	 * Gets the initial state of the NFA.
	 * 
	 * @return the initial {@link NFAState} of the NFA.
	 */
	public NFAState getInitialState() {
		return initialState;
	}


	/**
	 * Gets the final state of the NFA.
	 * 
	 * @return the final {@link NFAState} of the NFA.
	 */
	public NFAState getFinalState() {
		return finalState;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Initial State: "+ this.initialState + "\n");
		sb.append("Final State: "+ this.finalState + "\n");
		
		sb.append("Transitions:\n");
		for (NFATransition trans : this.transitions) {
			sb.append(trans + "\n");
		}
		
		return sb.toString();
	}
	
}
