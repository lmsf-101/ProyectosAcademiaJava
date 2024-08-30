package observer;

public class User implements Observer {
	

	private String userName;
	private String fullName;
	private Task currentTask;
	
	public User(String userName, String fullName, Task currentTask) {

		this.userName = userName;
		this.fullName = fullName;
		assignTask(currentTask);
	}
	
	public User(String userName, String fullName) {
		this.userName = userName;
		this.fullName = fullName;
	}



	public void assignTask(Task task) {
		if(currentTask != null)
			unassignTask();
		currentTask = task;
		currentTask.attach(this);
	}
	
	public void unassignTask() {
		try {
		currentTask.detach(this);
		} catch (NullPointerException e) {
			System.out.println("No task to remove....");
		}
	}

	@Override
	public void update() {
		System.out.println("\n--------------");
		System.out.println("Changes in current task [" + currentTask.getTitle()+"] for " + fullName + " ("+userName+")");
		System.out.println(currentTask.getLastChange());
		System.out.println("--------------\n");
	}

}
