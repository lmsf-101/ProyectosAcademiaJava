package builder.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import builder.Administrator;
import builder.ClassSchedule;
import builder.Course;
import builder.FlexibleScheduleBuilder;
import builder.ScheduleBuilder;
import builder.Student;

/*
 * JAVA PROGRAM EXAMPLE SHOWCASING THE BUILDER PATTERN
 * APPLYING UNIT TESTS
 * Made by: Luis Miguel Sánchez Flores
 */



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
	
	static List<Course> getTestCourses(String... courseCodes) {
		
		List<Course> courses = new ArrayList<>(courseCodes.length);
		
		for(String code: courseCodes) {
			Course course = COURSE_CATALOG.get(code);
			
			if(course != null)
				courses.add(course);
		}
		
		return courses;
		
	}
	
	
	// Test if the ScheduleBuilder is able to add the course into the list correctly:
	@Test
	void testAddedCourse() {
		System.out.println("TEST #1 - TEST ADD COURSE");
		Course courseToAdd = COURSE_CATALOG.get("CS301");
		
		ClassSchedule cs = new FlexibleScheduleBuilder(1)
								.addCourse(courseToAdd)
								.getSchedule();
		
		assertEquals(courseToAdd, cs.getCourses().get(0));
		
		System.out.println("TEST #1 - TEST ADD COURSE FINISHED\n");
	}
	
	// Test if the ScheduleBuilder provides the correct ClassSchedule, based on
	// the provided courses shown below:
	@Test
	void testClassScheduleGeneration() {
		System.out.println("TEST #2 - GENERATE CLASS SCHEDULE");
		
		List<Course> testCourses = getTestCourses(
				"ART310",
				"MUS121"
		);
		
		ClassSchedule expectedSchedule = new ClassSchedule(3, testCourses, 5);
		
		ClassSchedule cs = new FlexibleScheduleBuilder(3)
								.addCourse(COURSE_CATALOG.get("ART310"))
								.addCourse(COURSE_CATALOG.get("MUS121"))
								.setCredits()
								.getSchedule();
		
		assertEquals(expectedSchedule, cs);
		System.out.println("TEST #2 - GENERATE CLASS SCHEDULE FINISHED\n");
	}
	
	
	// Test out if the created schedule DOES NOT satisfy the min. amount of credits required:
	@Test
	void testLackOfMinimumCredits() {
		
		System.out.println("TEST #3 - INSUFICIENT AMOUNT OF CREDITS");
		
		boolean isValid = new FlexibleScheduleBuilder(0)
								.addCourse(COURSE_CATALOG.get("MUS121"))
								.addCourse(COURSE_CATALOG.get("ART310"))
								.setCredits()
								.isValidSchedule();
		
		assertFalse(isValid);
		
		System.out.println("TEST #3 - INSUFICIENT AMOUNT OF CREDITS FINISHED\n");
		
	}
	
	
	// Complex test to verify if the Administrator is able to assign
	// a correct schedule is assigned to the student:
	@Test
	void testCorrectSchedule() {
		
			System.out.println("TEST #4 - CORRECT CLASS SCHEDULE");
			
		   List<Course> listCourses = getTestCourses(
				   "CS101",
				   "MATH123",
				   "ENG110"
				   );
		   
		   // The expected schedule to be assigned to the student:
		   ClassSchedule expectedSchedule = new ClassSchedule(
				   5, listCourses, 11
		   );
	
		
			// Add a new administrator:
	        Administrator admin = new Administrator();
	        
	        // Create a new Student to add the flexible schedule:
	        Student student = new Student("John Doe");
	        
	        // Generate a flexible schedule builder
	        ScheduleBuilder flexSchedule = new FlexibleScheduleBuilder(5)
	        								.addCourse(COURSE_CATALOG.get("CS101"))
	        							    .addCourse(COURSE_CATALOG.get("MATH123"))
	        							    .addCourse(COURSE_CATALOG.get("ENG110"))
	        							    .setCredits();


	        // Asign the schedule to the student:
	        admin.assignSchedule(student, flexSchedule);

	        // Print out the student's schedule:
	        System.out.println("STUDENT SCHEDULE : \n" + student.getCurrentSchedule());
	        	
	        // Check if the student's schedule is the one expected:
	        assertEquals(expectedSchedule, student.getCurrentSchedule(), "This is an error");
	        
	        System.out.println("TEST #4 - CORRECT CLASS SCHEDULE FINISHED\n");
	}

	// Complex test to verify if the Administrator is able to assign
	// a correct schedule is assigned to the student:
	@Test
	void testIncompleteSchedule() {
		
		System.out.println("TEST #5 - INCOMPLETE CLASS SCHEDULE (less than Min. amount of credits required)");
		
		Administrator admin = new Administrator();
		
		Student student = new Student("Ashley Cole");
		
		// Create an incomplete schedule:
		ScheduleBuilder flexSchedule = new FlexibleScheduleBuilder(7)
				.addCourse(COURSE_CATALOG.get("BIOL205"))
			    .setCredits();
		
		// Try to assign it to a student:
		admin.assignSchedule(student, flexSchedule);
		
		// The administrator SHOULD reject the assignment, thus leaving the student's current schedule as null.
		assertNull(student.getCurrentSchedule());
		
		System.out.println("TEST #5 - INCOMPLETE CLASS SCHEDULE FINISHED\n");
	}
	
// --------------------------------------------------------------------
	
	// ADDITIONAL TESTS TO INCREMENT THE COVERAGE OF THE CODE
	
	@Test
	void testClassScheduleEqualsAndHash() {
		ClassSchedule cs1 = new ClassSchedule(2, 
							getTestCourses("CS301", "BIOL205"), 
							8);
		
		ClassSchedule cs2 = new ClassSchedule(2, 
				getTestCourses("CS301", "BIOL205"), 
				8);
		
		assertTrue(cs1.equals(cs2));
		assertEquals(cs1, cs1);
		assertFalse(cs1.equals(null));
		assertFalse(cs1.equals(List.of("Hello World!")));
		
		assertEquals(cs1.hashCode(), cs2.hashCode());
		
	}
	
	@Test
	void checkUniqueIDs() {
		Student student1 = new Student("John");
		Student student2 = new Student("Jane");
		
		assertNotEquals(student1.getID(), student2.getID());
	}
	
	void testUserSetName() {
		Student student1 = new Student("John");
		
		student1.setName("Jonathan");
		
		assertEquals("Jonathan", student1.getName());
	}
	
	@Test
	void testCourseEquals() {
		Course newCourse = new Course("ENG110", "English Composition", 3);
		
		Course courseFromCatalog = COURSE_CATALOG.get("ENG110");
		
		assertEquals(courseFromCatalog, newCourse);
	}
	
	@Test
	void testNullCourse() {
		Course nullCourse = null;
		
		Course actualCourse = COURSE_CATALOG.get("CS101");
		
		assertFalse(actualCourse.equals(nullCourse));
	}
	
	@Test
    void testCourseGetters() {
        Course course = new Course("999", "TEST SUBJECT", 100);

        assertEquals("999", course.getCode());
        assertEquals("TEST SUBJECT", course.getName());
        assertEquals(100, course.getCredits());
    }

    @Test
    void testCourseSetters() {
        Course course = new Course("CS101", "Introduction to Computer Science", 3);

        course.setCode("CS103");
        course.setName("Advanced Data Structures");
        course.setCredits(4);

        assertEquals("CS103", course.getCode());
        assertEquals("Advanced Data Structures", course.getName());
        assertEquals(4, course.getCredits());
    }
    
    @Test
    void testScheduleGetters() {
    	
    	int expectedSemester = 2;
    	int expectedCredits = 8;
    	
    	ClassSchedule cs = new ClassSchedule(expectedSemester, 
				getTestCourses("CS301", "BIOL205"), 
				8);
    	
    	assertEquals(expectedSemester, cs.getSemester());
    	
    	assertEquals(expectedCredits, cs.getCredits());
    }
	
    
    @Test
    void testHashCodeConsistency() {
        Course course = new Course("ART310", "Digital Painting", 3);
        
        int initialHash = course.hashCode();

        // Modify object state
        course.setName("ART312");

        // Check if hash code remains the same
        assertNotEquals(initialHash, course.hashCode());
    }
}

