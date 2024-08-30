package observer;

public enum Priority {
	NONE, LOW, MEDIUM, HIGH;
	
	public boolean isHigherPriority(Priority other) {
		return this.compareTo(other) > 0;
	}
}
