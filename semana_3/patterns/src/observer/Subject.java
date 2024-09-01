package observer;

// SUBJECT
// Defines the operations for attaching and detaching observers
public interface Subject {
	void attach(Observer o);
	void detach(Observer o);
	void notification();
}
