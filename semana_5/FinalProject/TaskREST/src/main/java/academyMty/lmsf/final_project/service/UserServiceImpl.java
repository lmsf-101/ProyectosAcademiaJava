package academyMty.lmsf.final_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academyMty.lmsf.final_project.model.User;
import academyMty.lmsf.final_project.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public User createUser(User user) {
		User newUser = userRepository.save(user);
		
		return newUser;
	}

	@Transactional
	@Override
	public void changePassword(User user) {
		
		User retrievedUser = getUserById(user.getID());
		
		retrievedUser.setPassword(user.getPassword());
		
		updateUser(retrievedUser);
		
		
	}
	
	@Transactional
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("No user with ID #"+id+" was found..."));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public long countUser() {
		return userRepository.count();
	}

	@Transactional
	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}
}
