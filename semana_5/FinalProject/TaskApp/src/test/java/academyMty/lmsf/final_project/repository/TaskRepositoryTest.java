package academyMty.lmsf.final_project.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
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
	
	Task t1 = new Task(0, "T1", Task.Status.TODO);;
	
	List<Task> exampleTasks = List.of(
			t1,
			new Task(0, "T2", Task.Status.DONE),
			 new Task(0, "T3", Task.Status.TODO)
			);
	
	@BeforeEach
	void setUp() {
		taskRepository.deleteAll();
		
		taskRepository.saveAll(exampleTasks);
	}

	@Test
	void findTasksOrderByStatus() {
		
		
		List<Task> tasks = taskRepository.findAll();
		
		
		List<Task> orderedTasks = taskRepository.findAllOrderByStatus();
		
		
		assertNotEquals(tasks, orderedTasks);
		
		tasks.sort((t1, t2) -> t1.getStatus().compareTo(t2.getStatus()));
		
		assertEquals(tasks, orderedTasks);
	}

	@Test
	void findTaskFound() {
		
		System.out.println(taskRepository.findAll().toString());
		
		final int ID = testEntityManager.getId(t1, Integer.class);
		
		Optional<Task> retrieveTask = taskRepository.findById(ID);
		
		System.out.println("Retrieved task : " + retrieveTask.get());
		
		assertEquals("T1", retrieveTask.get().getTitle());
	}
	
	@Test
	void findTaskNotFound() {
		
		final int INVALID_ID = -1;
		
		Optional<Task> invalidTask = taskRepository.findById(INVALID_ID);
		
		System.out.println("Is task object empty ? : " + invalidTask.isEmpty());
		
		assertTrue(invalidTask.isEmpty());
		
		
	}
	
	@Test
	void saveTask() {
		
		Task newTask = new Task(0, "New task !", Task.Status.TODO);
		
		taskRepository.save(newTask);
		
		//List<Task> tasks = taskRepository.findAll();
		
		assertTrue(taskRepository.findAll().contains(newTask));
		assertEquals(4, taskRepository.count());
		
		System.out.println(taskRepository.findAll().toString());
	}
	

}
