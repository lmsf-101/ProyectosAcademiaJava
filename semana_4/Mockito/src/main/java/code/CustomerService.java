package code;
import java.util.List;

// Serivce to mock with Mockito:

public interface CustomerService {
	
	List<Customer> findAll();
	Customer findById(int id);
	List<Customer> findByGender(String gender);
	List<Customer> findByDOB(String dob);
	Customer updateCustomer(Customer customer);
	void deleteCustomer(int id) throws RuntimeException;
	
}
