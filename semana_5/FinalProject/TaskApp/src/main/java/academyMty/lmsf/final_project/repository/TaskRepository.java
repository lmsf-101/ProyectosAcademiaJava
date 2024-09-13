package academyMty.lmsf.final_project.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import academyMty.lmsf.final_project.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	
	 // Get list of tasks order by the status:
	 @Query("SELECT t FROM Task t ORDER BY t.status ASC")
	 List<Task> findAllOrderByStatus();
	
}