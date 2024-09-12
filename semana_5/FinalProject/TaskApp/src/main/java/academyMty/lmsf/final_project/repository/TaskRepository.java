package academyMty.lmsf.final_project.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import academyMty.lmsf.final_project.model.Task;
import academyMty.lmsf.final_project.model.User;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	
	List<Task> findByUser(User user);
	
	 @Query("SELECT t FROM Task t ORDER BY t.status ASC")
	 List<Task> findAllOrderByStatus();
	 
	 List<Task> getTaskByTitleIgnoreCaseContaining(String title);
	
}