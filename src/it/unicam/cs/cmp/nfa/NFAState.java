package it.unicam.cs.cmp.nfa;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represent a state of a generic NFA.
 * 
 * @author RICCARDO
 *
 */
public class NFAState {
	// state unique identifier
	private Integer id;
	
	private boolean isInitial = false;

	private boolean isFinal = false;
	
	private Set<NFATransition> outgoingTransitions = new HashSet<>();
	
	/**
	 * Basic constructor.
	 * 
	 * Creates an empty state with only the id set up.
	 * The state is neither initial nor final.
	 * 
	 * @param id the unique identifier of the state.
	 */
	public NFAState(Integer id) {
		this.id = id;
	}

	/**
	 * Creates an either initial or final state.
	 * 
	 * This state has no outgoing transitions.
	 * 
	 * @param id the unique identifier of the state.
	 * @param isInitial whether the state is initial or final.
	 * 	      True if the state is initial, false if it is final.
	 */
	public NFAState(Integer id, Boolean isInitial) {
		this.id = id;
		this.isInitial = isInitial;
		this.isFinal = (isInitial) ? false : true;
	}
	
	/**
	 * Adds an outgoing transition.
	 * 
	 * @param outgoingTransition the outgoing transition to add.
	 */
	public void addTransition(NFATransition outgoingTransition) {
		this.outgoingTransitions.add(outgoingTransition);
	}


	/**
	 * Gets all the outgoing transitions.
	 * 
	 * @return {@link Set} of {@link NFATransition} representing all the outgoing transitions. 
	 */
	public Set<NFATransition> getOutgoingTransitions() {
		return outgoingTransitions;
	}

	/**
	 * Whether the state is initial.
	 * 
	 * @return {@code true} if it is initial, {@code false} otherwise.
	 */
	public boolean isInitial() {
		return isInitial;
	}

	/**
	 * Set this state as initial.
	 * 
	 * @param isInitial {@code true} to set it initial, {@code false} to unset it.
	 */
	public void setInitial(boolean isInitial) {
		this.isInitial = isInitial;
		this.isFinal = false;
	}

	/**
	 * Whether the state is final.
	 * 
	 * @return {@code true} if it is final, {@code false} otherwise.
	 */
	public boolean isFinal() {
		return isFinal;
	}

	/**
	 * Set this state as final.
	 * 
	 * @param isInitial {@code true} to set it final, {@code false} to unset it.
	 */
	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
		this.isInitial = false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NFAState other = (NFAState) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NFAState [id=" + id + "]";
	}

}
