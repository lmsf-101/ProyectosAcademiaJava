package academyMty.lmsf.final_project.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import academyMty.lmsf.final_project.model.Task;
import academyMty.lmsf.final_project.model.TaskId;
import academyMty.lmsf.final_project.model.User;

public interface TaskRepository extends JpaRepository<Task, TaskId> {
	
	List<Task> findByuId(long userId);
	
	//Task findByTaskId(int taskId, long userId);

}