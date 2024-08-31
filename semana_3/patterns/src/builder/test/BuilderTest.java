package builder;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class BuilderTest {
	
	static Map<String, Course> COURSE_CATALOG = Map.of(
			"CS101", new Course("CS101", "Introduction to Computer Science", 4),
			"ENG110", new Course("ENG110", "English Composition", 3),
			"BIOL205", new Course("BIOL205", "Biology II", 4),
			"MATH123", new Course("MATH123", "Calculus I", 4),
			"CS301", new Course("CS301", "Data Structures and Algorithms", 4),
			"MUS121", new Course("MUS121", "Music Theory Fundamentals", 2),
			"ART310", new Course("ART310", "Digital Painting", 3)
			);
	
	@Test
	void testCorrectSchedule() {
		
			System.out.println("TEST #1 - CORRECT CLASS SCHEDULE");
		
		   List<Course> listCourses = List.of(
				   COURSE_CATALOG.get("CS101"),
				   COURSE_CATALOG.get("MATH123"),
				   COURSE_CATALOG.get("ENG110")
		   	);
		   
		   ClassSchedule expectedSchedule = new ClassSchedule(
				   5, listCourses, 11
		   );
	
		
			// Add a new administrator:
	        Administrator admin = new Administrator();
	        
	        // Create a new Student to add the flexible schedule:
	        Student student = new Student("John Doe");
	        
	        // Generate a flexible schedule builder
	        FlexibleScheduleBuilder flexSchedule = new FlexibleScheduleBuilder(5)
	        								.addCourse(COURSE_CATALOG.get("CS101"))
	        							    .addCourse(COURSE_CATALOG.get("MATH123"))
	        							    .addCourse(COURSE_CATALOG.get("ENG110"))
	        							    .setCredits();

	        // Director gets the concrete builder object from the client
	        // (application code). That's because application knows better which
	        // builder to use to get a specific product.
	        
	        admin.assignSchedule(student, flexSchedule);

	        System.out.println("STUDENT SCHEDULE : \n" + student.getCurrentSchedule());
	        
	        assertEquals(expectedSchedule, student.getCurrentSchedule(), "This is an error");
	        
	        System.out.println("TEST #1 - CORRECT CLASS SCHEDULE FINISHED\n");
	}
	        
//	        CarBuilder builder = new CarBuilder();
//	        director.constructSportsCar(builder);
//
//	        // The final product is often retrieved from a builder object, since
//	        // Director is not aware and not dependent on concrete builders and
//	        // products.
//	        Car car = builder.getResult();
//	        System.out.println("Car built:\n" + car.getCarType());
//
//
//	        CarManualBuilder manualBuilder = new CarManualBuilder();
//
//	        // Director may know several building recipes.
//	        director.constructSportsCar(manualBuilder);
//	        Manual carManual = manualBuilder.getResult();
//	        System.out.println("\nCar manual built:\n" + carManual.print());
	
	@Test
	void testIncompleteSchedule() {
		
		System.out.println("TEST #2 - INCOMPLETE CLASS SCHEDULE (less than Min. amount of credits required)");
		
		Administrator admin = new Administrator();
		
		Student student = new Student("Ashley Cole");
		
		FlexibleScheduleBuilder flexSchedule = new FlexibleScheduleBuilder(7)
				.addCourse(COURSE_CATALOG.get("BIOL205"))
			    .setCredits();
		
		admin.assignSchedule(student, flexSchedule);
		
		assertNull(student.getCurrentSchedule());
		
		System.out.println("TEST #2 - INCOMPLETE CLASS SCHEDULE FINISHED");
	}
}

