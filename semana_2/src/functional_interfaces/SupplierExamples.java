package functional_interfaces;

import java.util.function.Supplier;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class SupplierExamples implements FuncInterfaceExamples {

	// Run the examples of the Supplier interface;
	@Override
	public void apply() {
		System.out.println("\nSUPPLIER EXAMPLES : ");
		generateRandomNumber(0, 100);
		newBorn("Alex");
		getCurrentDate();
		generateList("Hello", "World", "!");
	}
	
	// Generate a random number with a minimum and maximum limit:
	public static void generateRandomNumber(int min, int max) {
		System.out.println("\nGenerate random number from " + min + " to " + max);
		
		Supplier<Integer> randomNumber = () -> new Random().nextInt(min, max);
		
		System.out.println("Random number : " + randomNumber.get());
	}
	
	// Generate a newborn with a name:
	public static void newBorn(String name) {
		System.out.println("\nGenerate a newborn with the name : " + name);
		
		Supplier<Person> newPerson = () -> new Person(name);
		
		Person newBorn = newPerson.get();
		
		System.out.println(newBorn);
		
	}
	
	
	// Get the current Date:
	public static void getCurrentDate() {
		System.out.println("\nGet the current date :");
		
		Supplier<LocalDate> currentTime = LocalDate::now;
		
		LocalDate current = currentTime.get();
		
		System.out.println("Current date : " + current);
	}
	
	
	// Generate a new List collection with a predefined set of items:
	public static <E> void generateList(E... items) {
		System.out.println("\nGenerate a List using default items : " + Arrays.toString(items));
		
		Supplier<List<E>> getListWithItems = () -> List.of(items);
		
		List<E> newList = getListWithItems.get();
		
		System.out.println("NEW LIST : " + newList.getClass().getSimpleName() + " - " + newList);
	}
	

}

// AUXILIARY CLASS "PERSON" FOR THE 2ND EXAMPLE:
class Person {
	String name;
	int age;
	
	public Person() {
		this("John Doe", 0);
	}
	
	public Person(String name) {
		this(name, 0);
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "My name is " + name + ", and I'm " + age + " years old";
	}
	
	
}