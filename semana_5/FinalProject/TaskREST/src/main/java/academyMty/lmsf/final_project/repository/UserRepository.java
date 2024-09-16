package academyMty.lmsf.final_project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import academyMty.lmsf.final_project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	
}