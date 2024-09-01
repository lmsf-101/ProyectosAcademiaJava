package builder;


// Auxiliary class that simulates an Administrator of the university:

public class Administrator {
	
	// Checks if the schedule created by the builder is valid in order to assign it to the student:
	public void assignSchedule(Student student, ScheduleBuilder sb) {
		
		// Check if the schedule has the minimum amount of credits to be accepted:
		if (sb.isValidSchedule()) {
			System.out.println("The given schedule is valid! Assigning it to student " + student.getName() + "...");
			
			// Retrieve the schedule of the builder...
			ClassSchedule schedule = sb.getSchedule();
			
			// ..then set it up for the student:
			student.setCurrentSchedule(schedule);
			
		} 
		// Otherwise, print out the following error:
		else {
			System.err.println("The given schedule is invalid. Please add more classes to meet the minimum amount of credits required.");
			System.err.println(sb.getCredits() + " (SCHEDULE) < " + sb.getMinimumCredits() + " (MIN. CREDITS NEEDED)");
			
			
		}
	}
}
