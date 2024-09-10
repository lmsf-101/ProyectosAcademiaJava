package academyMty.lmsf.final_project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import academyMty.lmsf.final_project.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	
}