package builder;

public class Administrator {
	
	public void assignSchedule(Student student, ScheduleBuilder sb) {
		
		// Check if the schedule has the minimum amount of credits to be accepted:
		if (sb.isValidSchedule()) {
			System.out.println("The given schedule is valid! Assigning it to student " + student.getName() + "...");
			
			ClassSchedule schedule = sb.getSchedule();
			
			student.setCurrentSchedule(schedule);
		} else {
			System.err.println("The given schedule is invalid. Please add more classes to meet the minimum amount of credits required.");
			System.err.println(sb.getCredits() + " (SCHEDULE) < " + sb.getMinimumCredits() + " (MIN. CREDITS NEEDED)");
			
			
		}
	}
}
