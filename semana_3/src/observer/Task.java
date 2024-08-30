package observer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.text.DateFormatter;

public class Task implements Subject{
	
	private String title;
	private String description;
	private Priority priority;
	private String deadline;
	private String lastChange;
	private ArrayList<Observer> assignees;
	
	

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

	@Override
	public void attach(Observer o) {
		assignees.add(o);
	}

	@Override
	public void detach(Observer o) {
		assignees.remove(o);
		
	}

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

	public String getPriority() {
		return priority.name();
	}

	public void setPriority(Priority priority) {
		Priority prevPriority = this.priority;
		this.priority = priority;
		setLastChange("PRIORITY", getPriority());
		
		if(this.priority.isHigherPriority(prevPriority)) 
			notification();
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = getDeadlineString(deadline);
		setLastChange("DEADLINE", getDeadline());
		notification();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setLastChange(String type, String change) {
		lastChange = "LAST CHANGE MADE : NEW " + type + " - " + change;
	}
	
	public String getLastChange() {
		return lastChange;
	}
	
	public String getDeadlineString(LocalDate deadline) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		return deadline.format(df).toString();
	}

}
