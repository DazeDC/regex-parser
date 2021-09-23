package it.unicam.cs.cmp.nfa;

/**
 * This class represent a transition of a generic NFA.
 * 
 * @author RICCARDO
 *
 */
public class NFATransition {
	private String symbol;
	
	private NFAState source;
	
	private NFAState destination;
	
	/**
	 * Creates a transition between two states.
	 * 
	 * @param symbol the symbol associated to the transition
	 * @param source the state from where the transition exits
	 * @param destination the state where the transition arrives
	 */
	public NFATransition(String symbol, NFAState source, NFAState destination) {
		this.symbol = symbol;
		this.source = source;
		this.destination = destination;
	}

	/**
	 * Returns the symbol associated to the transition.
	 * 
	 * @return {@link String} representing the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * Sets the source from where the transition exits.
	 * 
	 * @param source an {@link NFAState} representing the source.
	 */
	public void setSource(NFAState source) {
		this.source = source;
	}

	/**
	 * Returns the source from where the transition exits.
	 * 
	 * @return an {@link NFAState} representing the source.
	 */
	public NFAState getSource() {
		return source;
	}

	/**
	 * Returns the destination towards which the transition goes to.
	 * 
	 * @return an {@link NFAState} representing the destination.
	 */
	public NFAState getDestination() {
		return destination;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
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
		NFATransition other = (NFATransition) obj;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.source);
		sb.append(" --" + this.symbol + "--> ");
		sb.append(this.destination);
		
		return sb.toString();
	}
	
	
	
}
