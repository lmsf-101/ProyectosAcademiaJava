package functional_interfaces;

import java.util.function.Supplier;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class SupplierExamples implements FuncInterfaceExamples {
	
	@Override
	public void apply() {
		System.out.println("SUPPLIER EXAMPLES : ");
		generateRandomNumber(0, 100);
		newBorn("Alex");
	}
	
	public static void generateRandomNumber(int min, int max) {
		System.out.println("\nGenerate random number from " + min + " to " + max);
		
		Supplier<Integer> randomNumber = () -> new Random().nextInt(min, max);
		
		System.out.println("Random number : " + randomNumber.get());
	}
	
	public static void newBorn(String name) {
		System.out.println("\nGenerate a newborn with the name : " + name);
		
		Supplier<Person> newPerson = () -> new Person(name);
		
		Person newBorn = newPerson.get();
		
		System.out.println(newBorn);
		
	}
	

}

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