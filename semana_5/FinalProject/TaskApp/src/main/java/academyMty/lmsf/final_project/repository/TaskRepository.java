package academyMty.lmsf.final_project.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import academyMty.lmsf.final_project.model.Task;
import academyMty.lmsf.final_project.model.TaskId;

public interface TaskRepository extends JpaRepository<Task, TaskId> {
	
	//TODO Define CRUD operations for Composite Key
	
	@Query("SELECT t FROM Task t WHERE t.uId = :userId")
	List<Task> findByUser(long userId);
	
	@Query("SELECT t FROM Task t WHERE t.tId = :taskId AND t.uId = :userId")
	Optional<Task> findTaskByUser(int taskId, long userId);
	
	@Query("SELECT COUNT(*) FROM Task t WHERE t.uId = :userId")
	long countTasks(long userId);
	
//	@Query("SELECT t FROM Task t WHERE t.uId = :userId ORDER BY t.tId")
//	List<Task> orderedTasks(long userId);
	
	//Task findByTaskId(int taskId, long userId);

}