package code;
import java.util.List;


// Controller in which it depends on CustomerService 
// to demonstrate the client(s) to the user. 

public class Controller {
	
	// Dependency
	CustomerService customerService;
	
	
	public Controller(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	public Customer findCustomerById(int id) {
		Customer retrievedCustomer = customerService.findById(id);
		
		if(retrievedCustomer == null)
			throw new RuntimeException("There's no customer with the ID #"+id+"....");
		
		return retrievedCustomer;
	}
	
	public List<Customer> findCustomersByGender(String gender) {
		List<Customer> retrievedCustomers = customerService.findByGender(gender);
		
		return retrievedCustomers;
	}

	public List<Customer> findCustomersByDOB(String dob) {
		
		List<Customer> retrievedCustomers = customerService.findByDOB(dob);
		
		return retrievedCustomers;
	}
	
	public Customer updateCustomer(Customer newCustomer) {
		
		Customer oldCustomer = customerService.findById(newCustomer.getId());
		
		Customer retrievedCustomer =  customerService.updateCustomer(newCustomer);
		
		return retrievedCustomer;
		
	}
	
	public void deleteById(int id) {
		 customerService.deleteCustomer(id);
	}
	
	
}
