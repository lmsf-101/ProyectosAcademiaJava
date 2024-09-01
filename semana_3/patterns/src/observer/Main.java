package observer;

import java.time.LocalDate;

/*
 * JAVA PROGRAM EXAMPLE SHOWCASING THE OBSERVER PATTERN
 * Made by: Luis Miguel Sánchez Flores
 */


public class Main {

	public static void main(String[] args) {
		
		// Create some new Tasks
		Task task1 = new Task("Create Project", "Generate a new project in Eclipse IDE", Priority.LOW, LocalDate.now());
		Task task2 = new Task("Plan pizza party", "Plan out the pizza party for the team :)", Priority.MEDIUM);
		
		// Print out the task's info:
		System.out.println(task1);
		System.out.println(task2);
		
		// Generate some new users!
		User user1 = new User("alito91", "Alan Gonzalez");
		User user2 = new User("dan_marker", "Dan Evergreen");
		User user3 = new User("dodgersfan_101", "Vincent Roll");
		
		// Assign both user1 and user2 to the first task....
		user1.assignTask(task1);
		user2.assignTask(task1);
		
		// .....while the user3 is assigned with the second one.
		user3.assignTask(task2);
		
		// The project needs to be created as soon as possible!
		System.out.println("NEW PRIORITY FOR TASK 1 :");
		task1.setPriority(Priority.HIGH);
		
		
		// On second thought, the pizza party can wait a bit...
		System.out.println("NEW DEADLINE FOR TASK 2 :");
		task2.setDeadline(LocalDate.now().plusDays(5));
		
		// Remove user1 from its task
		user1.unassignTask();
		
		// Now change the title. We don't need Eclipse:
		System.out.println("NEW TITLE FOR TASK 1 :");
		task1.setTitle("Generate new project");
		
		// Nevermind, the project is no longer a priority....
		System.out.println("NEW LOW PRIORITY FOR TASK 1 :");
		task1.setPriority(Priority.NONE);
		System.out.println("No notifications here....\n");
		
		
		// Print out the modified tasks:
		System.out.println(task1);
		System.out.println(task2);

	}

}
