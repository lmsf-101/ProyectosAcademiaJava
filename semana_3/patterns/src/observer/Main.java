package observer;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Task task1 = new Task("Create Project", "Generate a new project in Eclipse IDE", Priority.LOW, LocalDate.now());
		Task task2 = new Task("Plan pizza party", "Plan out the pizza party for the team :)", Priority.MEDIUM);
		//Task task3 = new Task("Get new requirements", "Write down the client's new requirements for the project", Priority.MEDIUM, LocalDate.of(2024, 8, 3));
		
		
		System.out.println(task1);
		System.out.println(task2);
		
		User user1 = new User("alito91", "Alan Gonzalez");
		User user2 = new User("dan_marker", "Dan Evergreen");
		User user3 = new User("dodgersfan_101", "Vincent Roll");
		
		user1.assignTask(task1);
		user2.assignTask(task1);
		
		user3.assignTask(task2);
		
		
		task1.setPriority(Priority.HIGH);
		
		task2.setDeadline(LocalDate.now().plusDays(5));
		
		user1.unassignTask();
		
		task1.setTitle("Generate new project");
		
		task1.setDeadline(LocalDate.now().plusDays(2));
		
		System.out.println(task1);
		System.out.println(task2);

	}

}
