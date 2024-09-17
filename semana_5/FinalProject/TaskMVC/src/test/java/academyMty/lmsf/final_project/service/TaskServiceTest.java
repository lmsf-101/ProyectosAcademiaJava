package academyMty.lmsf.final_project.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import academyMty.lmsf.final_project.model.Task;
import academyMty.lmsf.final_project.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;

class TaskServiceTest {
	
	// Treat TaskRepository as a Mock Object
	@Mock
	TaskRepository taskRepository;
	
	// Mark TaskService as an attribute in which Mock objects will be injected to
	@InjectMocks
	TaskServiceImpl taskService;
	
	List<Task> exampleList;

	
	// Before every test in the class:
	@BeforeEach
	void setUp() throws Exception {
		// Initialize the Mock objects
		MockitoAnnotations.openMocks(this);
		
		
		// Create a new list and Pre-populate it with a few tasks:
		exampleList = new ArrayList<>(List.of(
				
				new Task(1, "Test 1", Task.Status.TODO),
				new Task(2, "Test 2", Task.Status.DONE),
				new Task(3, "Test 3", Task.Status.TODO)
				
				)); 
	}

	
	// Check if the list of tasks retrieved are ordered by their status (first TODO, then DONE) 
	@Test
	void findAllTasksInOrderOfStatus() {
		
		List<Task> exampleCopy = new ArrayList<>(exampleList);		
		
		Comparator<Task> comparator = (t1, t2) -> t1.getStatus().compareTo(t2.getStatus());
		
		exampleCopy.sort(comparator);
		
		// Mockito feature
		// If the findAllOrderByStatus() is invoked, mock it by returning the example, sorted copy created:
		when(taskRepository.findAllOrderByStatus()).thenReturn(
				exampleCopy
				);
		
		// Test it out by calling the taskService
		List<Task> tasks = taskService.findAllTasks();
	
		assertNotNull(tasks);
		
		assertNotEquals(tasks, exampleList); // Expected: TRUE
		
		exampleList.sort(comparator);
		
		assertEquals(tasks, exampleList); // Expected: TRUE
	}
	
	// Test out the retrieval of a individual task by its ID;
	@Test
	void testGetTaskById() {
		final int ID = 1;
		
		Task taskToRetrieve = exampleList.get(ID-1);
		
		// Simulate the return of the task by its ID:
		when(taskRepository.findById(ID)).thenReturn(Optional.of(taskToRetrieve));
		
		Task task = taskService.getTaskById(ID);
		
		assertEquals(taskToRetrieve, task); // Expected: TRUE
		
	}
	
	// Test out the throw Exception when an invalid ID is passed when finding the task:
	@Test
	void testGetTaskByIdNotFound() {
		
		final int INVALID_ID = -9;
		
		// If an invalid ID is passed to the repository, respond with a EntityNotFoundException
		when(taskRepository.findById(INVALID_ID)).thenThrow(EntityNotFoundException.class);
		
		
		assertThrows(EntityNotFoundException.class, () -> taskService.getTaskById(INVALID_ID)); //Expected: EXCEPTION THROWN
		
	}

	
	// Test out the CREATE operation with the repository / service
	@Test
	void addATask() {
		
		Task newTask = new Task(4, "New test", Task.Status.TODO);
		
		// Mock the save function of TaskRepository to add newTask onto the exampleList:
		doAnswer(new Answer<Task>() {

			@Override
			public Task answer(InvocationOnMock invocation) throws Throwable {
				exampleList.add(invocation.getArgument(0));
				return null;
			}
			
		}).when(taskRepository).save(newTask);
		
		// Call the service function:
		taskService.addTask(newTask);
		
		
		// Check if the list increased its size to 4:
		assertEquals(4, exampleList.size());
		
		// Does it contain the newTask?
		assertTrue(exampleList.contains(newTask));
		
		// Verify that the taskRepository never checks it's ID, since it is supposed to be creating a new task
		verify(taskRepository, never()).findById(any());
	}

	
	// Test out the UPDATE operation
	@Test
	void testUpdateTask() {
		
		// Create Task object with existing ID
		final int ID = 2;
		Task oldTask = exampleList.get(ID-1);
		
		// New task object with same ID, but different attributes:
		Task changeTask = new Task(ID, "Change task", Task.Status.TODO);
		
		
		// Mock findById that should return the oldTask if the corresponding ID is passed:
		when(taskRepository.findById(changeTask.getID())).thenReturn(Optional.of(oldTask));
		
		// Mock the update to save the new changes of the existing task:
		when(taskRepository.save(changeTask)).thenReturn(changeTask);
		
		Task savedTask = taskService.updateTask(changeTask);
		
		
		assertNotNull(savedTask.getID());
		assertEquals("Change task", savedTask.getTitle());
		
		// Verify if the findById() method was called, checking beforehand that the task exists
		verify(taskRepository).findById(ID);
		
	}
	
	// Test out the Throw Exception when an UPDATE fails:
	@Test
	void testUpdateTaskFail() {
		
		final int ID = 2;
		
		// Create Task object with different ID
		Task changeTask = new Task(9, "Change task", Task.Status.TODO);
		
		// Task object that has nothing to do with the previous one
		Task oldTask = exampleList.get(ID-1);
		
		
		// If the ID is invalid, return a empty Optional:
		when(taskRepository.findById(changeTask.getID())).thenReturn(Optional.empty());
		
		// Check if the IDs are different:
		assertNotEquals(oldTask.getID(), changeTask.getID());

		
		// Check if the update throws the exception when passing an invalid ID:
		assertThrows(EntityNotFoundException.class, () -> taskService.updateTask(changeTask));
		
	}

	
	// Test out the DELETE operation of an task by its ID:
	@Test
	void testRemoveTaskById() {
		
		final int ID = 2;
		
		// Retrieve the task from the list:
		Task taskToDelete = exampleList.get(ID-1);
		
		// Simulate the removal of the task from the list when deleteById() function is invoked:
		doAnswer(new Answer<Integer>() {

			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				// get ID
				int id = invocation.getArgument(0);

				// Check every Task object in the list
				// and if any match the ID passed, remove it from the list:
				for(Task t : exampleList) {
					if (t.getID() == id) {
						exampleList.remove(t);
						break;
					}
				}
				return null;
			}
			
		}).when(taskRepository).deleteById(anyInt());
		
		// Call the service function:
		taskService.removeTaskById(ID);
		
		// Check if the list still contains the deleted task after the operation:
		assertFalse(exampleList.contains(taskToDelete));
		
		// Did it reduce its size by 2?
		assertEquals(2, exampleList.size());
	}


}
