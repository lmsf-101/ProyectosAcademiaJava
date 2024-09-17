package academyMty.lmsf.final_project.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import academyMty.lmsf.final_project.entity.Task;
import academyMty.lmsf.final_project.entity.TaskId;

// TASK REPOSITORY

public interface TaskRepository extends JpaRepository<Task, TaskId> {
	
	// Retrieve the list of tasks for a particular user:
	@Query("SELECT t FROM Task t WHERE t.uId = :userId")
	List<Task> findByUser(long userId);
	
	// Retrieve a specific task, from a specific user:	
	@Query("SELECT t FROM Task t WHERE t.tId = :taskId AND t.uId = :userId")
	Optional<Task> findTaskByUser(int taskId, long userId);
	
	// Count the number of tasks for a particular user:
	@Query("SELECT COUNT(*) FROM Task t WHERE t.uId = :userId")
	long countTasks(long userId);

}