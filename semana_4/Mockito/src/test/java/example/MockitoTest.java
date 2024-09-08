package example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.Controller;
import code.Customer;
import code.CustomerService;

import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class MockitoTest {
	
	// Specify the field to be mocked:
	@Mock 
	CustomerService customerService;
	
	// Specify the test object to be injected with the corresponding mocks:
	@InjectMocks
	Controller controller;
	
	
	// Auxiliary Customer objects for the tests:
	Customer exampleCustomer = new Customer(1, "John", "Doe", "johndoe@example.com", "Male", "12345678", "United States", "09-03-1990");

	List<Customer> exampleList = new ArrayList<>(List.of(
			exampleCustomer,
			new Customer(2, "Jane", "Doe", "janedoe@example.com", "Female", "87654321", "United States", "01-04-1989"),
			new Customer(4, "Victor", "Van Dam", "vandamman3@gmail.com", "Male", "43215678", "Jamaica", "11-09-1997"),
			new Customer(5, "Fredrick", "Durst", "fa_guy@hotmail.com", "Male", "87654321", "United States", "09-03-1990"),
			new Customer(6, "Jane", "Doe", "janedoe@example.com", "Female", "87654321", "United States", "01-04-1989")
			));
	
	@BeforeEach
	void setUp() {
		// Initialize fields with the Mockito annotations:
		MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	void restart() {
		// Reset the mocked service to it's initial state:
		reset(customerService);
	}
	
	
	// Mockito automatically assings a default value based on the method's return datatype.
	// In this case, since findAll() returns a List, Mockito assigns a empty list as its default value:
	@Test
	void testEmptyList() {
		assertEquals(true, customerService.findAll().isEmpty());
	}
	
	@Test
	void returnListOfMaleEmployees() {
		
		final String MALE_GENDER = "Male";
		
		// Mock the function call and the desired data returned, given a specific argument
		// When the customerService calls findByGender(MALE_GENDER), it should return the list of male customers:
			
		// if findByGender() is called with a "Male" argument, then it should return a list of only male customers
		when(customerService.findByGender(MALE_GENDER)).thenReturn(List.of(
				exampleList.get(0), // <- John Doe
				exampleList.get(2), // <- Victor Van Dam
				exampleList.get(3) // <- Fredrick Durst
		));
		
		// Get all male customers with the controller:
		List<Customer> maleCustomers = controller.findCustomersByGender(MALE_GENDER);
		
		// Check if the retrieved list only includes male customers:
		boolean areAllMale = maleCustomers.stream().allMatch(c -> c.getGender().equals("Male"));
		
		assertTrue(areAllMale);
	}
	
	// Another example of stubbing:
	@Test
	void testInvalidID() {
		
		final int INVALID_ID = -1;
		
		// If an Invalid Id is passed, then return a null value:
		when(customerService.findById(INVALID_ID)).thenReturn(null);
		
		assertThrows(RuntimeException.class, () -> controller.findCustomerById(INVALID_ID), "The test failed to provide the RuntimeException!\n");
	}
	
	@Test
	void testCustomerUpdate() {
		Customer newCustomer = new Customer(1, "John", "Dale", "johndale@example.com", "Male", "123456999", "United States", "09-03-1990");
		
		// For now, return a new customer for any existing Customer object:
		when(customerService.updateCustomer(any(Customer.class))).thenReturn(newCustomer);
		
		// Update the example customer with the new customer's details:
		Customer updatedCustomer = controller.updateCustomer(exampleCustomer);
		
		// Mockito offers the verify() methods to ensure that a specific method / behavior has been achieved
		// Here, we check if CustomerService invoked the findById() method to verify if the ID of the exampleCustomer 
		// has been checked out during the update process:
		verify(customerService).findById(anyInt());
		
		
		// Throws a NeverWantedButInvoked error:
		//verify(customerService, never()).findById(anyInt());

	}
	
	
	// Testing out Mockito stubbing for void methods
	@Test
	void testDeletingCustomerError() {
		
		assertThrows(RuntimeException.class, () -> {
			// For now, throw the RuntimeException of the deleteCustomer method when called:
			doThrow().when(customerService).deleteCustomer(anyInt());
		});
	}

	
	// Check if 
	@Test
	void testCorrectDOBArgument() {
		
		
		final String DOB_TO_SEARCH = "09-03-1990";
		
		// Create an ArgumentCaptor object that captures Strings:
		ArgumentCaptor<String> dobArgument = ArgumentCaptor.forClass(String.class);
		
//		when(customerService.findByDOB(DOB_TO_SEARCH)).thenReturn(List.of(
//				exampleList.get(0),
//				exampleList.get(4)
//				));

		
		// Call the controller method to find the customers by DOB, passing the following argument:
		List<Customer> customers = controller.findCustomersByDOB(DOB_TO_SEARCH);
		
		// Check if the findByDOB was called, and while doing so, capture the arguments:
		verify(customerService).findByDOB(dobArgument.capture());
		
		// Print out the captured arguments:
		System.out.println("Captured arguments in findByDOB : " + dobArgument.getValue());
		
		
		
		assertEquals(DOB_TO_SEARCH, dobArgument.getValue());
	}
	
	

}
