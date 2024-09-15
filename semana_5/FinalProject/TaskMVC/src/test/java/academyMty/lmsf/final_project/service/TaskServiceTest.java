package academyMty.lmsf.final_project.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collections;
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
	
	@Mock
	TaskRepository taskRepository;
	
	@InjectMocks
	TaskServiceImpl taskService;
	
	List<Task> exampleList;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		
		exampleList = new ArrayList<>(List.of(
				
				new Task(1, "Test 1", Task.Status.TODO),
				new Task(2, "Test 2", Task.Status.DONE),
				new Task(3, "Test 3", Task.Status.TODO)
				
				)); 
	}

	@Test
	void findAllTasksInOrderOfStatus() {
		
		List<Task> exampleCopy = new ArrayList<>(exampleList);		
		
		Comparator<Task> comparator = (t1, t2) -> t1.getStatus().compareTo(t2.getStatus());
		
		exampleCopy.sort(comparator);
		
		when(taskRepository.findAllOrderByStatus()).thenReturn(
				exampleCopy
				);
		
		
		List<Task> tasks = taskService.findAllTasks();
		
		assertNotNull(tasks);
		
		
		assertNotEquals(tasks, exampleList);
		
		exampleList.sort(comparator);
		
		assertEquals(tasks, exampleList);
	}
	
	@Test
	void testGetTaskById() {
		final int ID = 1;
		
		Task taskToRetrieve = exampleList.get(ID-1);
		
		when(taskRepository.findById(ID)).thenReturn(Optional.of(taskToRetrieve));
		
		Task task = taskService.getTaskById(ID);
		
		assertEquals(taskToRetrieve, task);
		
	}
	
	@Test
	void testGetTaskByIdNotFound() {
		
		final int INVALID_ID = -9;
		
		
		when(taskRepository.findById(INVALID_ID)).thenThrow(EntityNotFoundException.class);
		
		
		assertThrows(EntityNotFoundException.class, () -> taskService.getTaskById(INVALID_ID));
		
	}

	@Test
	void addATask() {
		
		Task newTask = new Task(4, "New test", Task.Status.TODO);
		
		doAnswer(new Answer<Task>() {

			@Override
			public Task answer(InvocationOnMock invocation) throws Throwable {
				exampleList.add(invocation.getArgument(0));
				return null;
			}
			
		}).when(taskRepository).save(newTask);
		
		
		taskService.addTask(newTask);
		

		assertEquals(4, exampleList.size());
		assertTrue(exampleList.contains(newTask));
		
		verify(taskRepository, never()).findById(any());
	}

	@Test
	void testUpdateTask() {
		
		// Create Task object with existing ID
		final int ID = 2;
		Task oldTask = exampleList.get(ID-1);
		
		Task changeTask = new Task(ID, "Change task", Task.Status.TODO);
		
		when(taskRepository.findById(changeTask.getID())).thenReturn(Optional.of(oldTask));
		
		when(taskRepository.save(changeTask)).thenReturn(changeTask);
		
		Task savedTask = taskService.updateTask(changeTask);
		
		assertNotNull(savedTask.getID());
		assertEquals("Change task", savedTask.getTitle());
		
		verify(taskRepository).findById(ID);
		
	}
	
	@Test
	void testUpdateTaskFail() {
		
		final int ID = 2;
		
		// Create Task object with different ID
		Task changeTask = new Task(9, "Change task", Task.Status.TODO);
		
		Task oldTask = exampleList.get(ID-1);
		
		
		// If the ID is invalid, return a empty Optional:
		when(taskRepository.findById(changeTask.getID())).thenReturn(Optional.empty());
		
		// Check if the IDs are different:
		assertNotEquals(oldTask.getID(), changeTask.getID());

		
		// Check if the update throws the exception when passing an invalid ID:
		assertThrows(EntityNotFoundException.class, () -> taskService.updateTask(changeTask));
		
	}

	@Test
	void testRemoveTaskById() {
		
		final int ID = 2;
		
		Task taskToDelete = exampleList.get(ID-1);
		
		//System.out.println("Task to Delete : " + taskToDelete);
		
		doAnswer(new Answer<Integer>() {

			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				
				int id = invocation.getArgument(0);
				
				System.out.println(id);
				
				for(Task t : exampleList) {
					System.out.println(t);
					if (t.getID() == id) {
						exampleList.remove(t);
						break;
					}
				}
				return null;
			}
			
		}).when(taskRepository).deleteById(anyInt());
		
		
		taskService.removeTaskById(ID);
		
		//System.out.println("New list : " + exampleList);
		
		assertFalse(exampleList.contains(taskToDelete));
		assertEquals(2, exampleList.size());
	}


}
