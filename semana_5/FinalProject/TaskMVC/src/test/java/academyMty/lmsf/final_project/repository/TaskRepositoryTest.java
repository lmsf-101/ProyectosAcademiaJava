package academyMty.lmsf.final_project.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import academyMty.lmsf.final_project.model.Task;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class TaskRepositoryTest {

	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	TestEntityManager testEntityManager;
	
	// Example task object
	Task t1 = new Task(0, "T1", Task.Status.TODO);;
	
	// Example list of tasks
	List<Task> exampleTasks = List.of(
			t1,
			new Task(0, "T2", Task.Status.DONE),
			 new Task(0, "T3", Task.Status.TODO)
			);
	
	// Before each test:
	@BeforeEach
	void setUp() {
		// Reset the database by deleting all entities
		taskRepository.deleteAll();
		
		// Save all the tasks examples from the list
		taskRepository.saveAll(exampleTasks);
	}

	
	// Check if the list of tasks retrieved are order by their Status:
	@Test
	void findTasksOrderByStatus() {
		
		
		List<Task> tasks = taskRepository.findAll();
		
		
		List<Task> orderedTasks = taskRepository.findAllOrderByStatus();
		
		// Are they different in terms of order?
		assertNotEquals(tasks, orderedTasks);
		
		// Sort the original task
		tasks.sort((t1, t2) -> t1.getStatus().compareTo(t2.getStatus()));
		
		assertEquals(tasks, orderedTasks);
	}

	// Test out the correct retrieval of an individual task:
	@Test
	void findTaskFound() {
		
		// Retrieve the ID of a particular task using the TestEntityManager:
		final int ID = testEntityManager.getId(t1, Integer.class);
		
		// Get the task by the retrieved ID
		Optional<Task> retrieveTask = taskRepository.findById(ID);
		
		// Check if the title is the expected "T1":
		assertEquals("T1", retrieveTask.get().getTitle());
	}
	
	// Failure test when an invalid ID is passed to findById():
	@Test
	void findTaskNotFound() {
		
		final int INVALID_ID = -1;
		
		Optional<Task> invalidTask = taskRepository.findById(INVALID_ID);
		
		// Check if the repository return an empty value
		assertTrue(invalidTask.isEmpty());
		
		
	}

	// Test out the save feature of the repository:
	@Test
	void saveTask() {
		
		// New task object to be added:
		Task newTask = new Task(0, "New task !", Task.Status.TODO);
		
		// Save it to the database with the repository
		taskRepository.save(newTask);
		
		// Check if the newTask is included in the list:
		assertTrue(taskRepository.findAll().contains(newTask));
		
		// Is the list now of size 4?
		assertEquals(4, taskRepository.count());
		
	}
	

}
