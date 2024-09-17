package academyMty.lmsf.final_project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import academyMty.lmsf.final_project.entity.User;

// USER REPOSITORY

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	
}