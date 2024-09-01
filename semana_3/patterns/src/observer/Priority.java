package observer;

// Enum that sets the level of priority of the task:
public enum Priority {
	NONE, LOW, MEDIUM, HIGH;
	
	// Check if the current priority is higher that the other priority:
	public boolean isHigherPriority(Priority other) {
		return this.compareTo(other) > 0;
	}
}
