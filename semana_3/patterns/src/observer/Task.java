package observer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.text.DateFormatter;

// CONCRETE OBSERVABLE / SUBJECT
// Maintains the state of the object and notifies the attached Observers when a change occurs
// In this case, the Task subject notifies the User when a higher priority or a stricter deadline is 
// assigned to the task.

public class Task implements Subject{
	
	private String title;
	private String description;
	private Priority priority;
	private String deadline;
	private String lastChange;
	private ArrayList<Observer> assignees;
	
	
	// ---- CONSTRUCTORS ----------------------
	public Task(String title, String description, Priority priority, LocalDate deadline) {
		this.title = title;
		this.description = description;
		this.priority = priority;
		
		this.deadline = getDeadlineString(deadline);
		assignees = new ArrayList<>();
	}
	
	public Task(String title) {
		this(title, "", Priority.NONE, LocalDate.now().plusDays(7));
	}
	
	public Task(String title, String description) {
		this(title, description, Priority.NONE, LocalDate.now().plusDays(7));
	}
	
	public Task(String title, String description, Priority priority) {
		this(title, description, priority, LocalDate.now().plusDays(7));
	}
	
	public Task(String title, String description, LocalDate deadline) {
		this(title, description, Priority.NONE, deadline);
	}
	
	// --------------------------------------------

	
	// Adds the observer to the instance's list
	@Override
	public void attach(Observer o) {
		assignees.add(o);
	}
	
	
	// Removes the observer to the instance's list
	@Override
	public void detach(Observer o) {
		assignees.remove(o);
		
	}
	
	// Notifies each of the observers when a change in state occurs
	@Override
	public void notification() {
		for(Observer assignee: assignees)
			assignee.update();
		
	}
	
	

	@Override
	public String toString() {
		return "TASK : \n" + 
				"TITLE - " + getTitle() + "\n" +
			   "DESCRIPTION - " + getDescription() + "\n" +
			   "PRIORITY - " + getPriority() + "\n" +
			   "DEADLINE - " + getDeadline() + "\n";
	}
	
	// ---- GETTERS AND SETTERS -------

	public String getPriority() {
		return priority.name();
	}

	public void setPriority(Priority priority) {
		Priority prevPriority = this.priority;
		this.priority = priority;
		setLastChange("PRIORITY", getPriority());
		
		// If the priority of the task has changed to a higher level, then notify
		// the observers (users) about it!
		if(this.priority.isHigherPriority(prevPriority)) 
			notification();
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = getDeadlineString(deadline);
		setLastChange("DEADLINE", getDeadline());
		
		// Notify the observers (users) when the deadline for the task has changed
		notification();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		setLastChange("TITLE", getTitle());
		
		notification();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		
		// No notification is needed for this one....
	}
	
	// Set up the type of change made recently in the task:
	public void setLastChange(String type, String change) {
		lastChange = "LAST CHANGE MADE : NEW " + type + " - " + change;
	}
	
	public String getLastChange() {
		return lastChange;
	}
	
	// -----------------------------------------------------------
	
	
	// Transform the LocalDate into a String with the appropriate format:
	public String getDeadlineString(LocalDate deadline) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		return deadline.format(df).toString();
	}

}
