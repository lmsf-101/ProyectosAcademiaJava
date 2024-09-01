package observer;

// CONCRETE OBSERVER

// Implements the Observer's methods to establish what it needs to do when a change in the Observable occurs
// In this case, it prints out to the user the last change made in his/her current assigned task:

public class User implements Observer {
	

	private String userName;
	private String fullName;
	private Task currentTask;
	
	
	// ---- CONSTRUCTOR ----------------------
	
	public User(String userName, String fullName, Task currentTask) {

		this.userName = userName;
		this.fullName = fullName;
		assignTask(currentTask);
	}
	
	public User(String userName, String fullName) {
		this.userName = userName;
		this.fullName = fullName;
	}

	// ------------------

	// Assign the users with the provided task
	public void assignTask(Task task) {
		if(currentTask != null) // <- If the user has already a task assigned, remove it
			unassignTask();
		currentTask = task;
		currentTask.attach(this);
	}
	
	// Removes the user from the assigned task (if it applies)
	public void unassignTask() {
		try {
		currentTask.detach(this);
		} catch (NullPointerException e) {
			System.out.println("No task to remove....");
		}
	}

	// Print out the last changes made to the assigned task, such as the level of priority or its deadline:
	@Override
	public void update() {
		System.out.println("\n--------------");
		System.out.println("Changes in current task [" + currentTask.getTitle()+"] for " + fullName + " ("+userName+")");
		System.out.println(currentTask.getLastChange());
		System.out.println("--------------\n");
	}

}
