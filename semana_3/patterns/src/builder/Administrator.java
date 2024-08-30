package builder;

public class Administrator {
	
	public void assignSchedule(Student student, FlexibleScheduleBuilder sb) {
		int credits = sb.getSchedule().getCredits();
		
		// Check if the schedule has the minimum amount of credits to be accepted:
		if (credits >= ClassSchedule.MIN_AMOUNT_CREDITS) {
			System.out.println("The given schedule is valid! Assigning it to student " + student.getName() + "...");
			
			ClassSchedule schedule = sb.getSchedule();
			
			student.setCurrentSchedule(schedule);
		} else {
			System.err.println("The given schedule is invalid. Please add more classes to meet the minimum amount of credits required.");
			System.err.println(credits + " (SCHEDULE) < " + ClassSchedule.MIN_AMOUNT_CREDITS + " (MIN. CREDITS NEEDED)");
			
			
		}
	}
}
