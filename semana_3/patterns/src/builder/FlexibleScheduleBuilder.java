package builder;

public class FlexibleScheduleBuilder extends ScheduleBuilder {
	public static int MINIMUM_CREDITS = 8;
	
	public FlexibleScheduleBuilder(int semester) {
		super(semester);
	}

	@Override
	public ScheduleBuilder addCourse(Course c) {
		courses.add(c);
		return this;
	}

	@Override
	public ScheduleBuilder setCredits() {
		totalCredits = 0;
		courses.forEach(course -> totalCredits += course.getCredits());
		return this;
	}
	
	@Override
	public int getMinimumCredits() {
		return MINIMUM_CREDITS;
	}
	
	@Override
	public boolean isValidSchedule() {
		return totalCredits >= MINIMUM_CREDITS;
	}
	
	public int getCredits() {
		return totalCredits;
	}
}
