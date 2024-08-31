package builder;

import java.util.ArrayList;

public abstract class ScheduleBuilder {
	
	int semester;
	ArrayList<Course> courses;
	int totalCredits;
	
	public abstract ScheduleBuilder addCourse(Course c);
	public abstract ScheduleBuilder setCredits();
	public abstract boolean isValidSchedule();
	public abstract int getMinimumCredits();
	
	public ScheduleBuilder(int semester) {
		this.semester = semester;
		courses = new ArrayList<>();
		totalCredits = 0;
	}
	
	public ClassSchedule getSchedule() {
		return new ClassSchedule(semester, courses, totalCredits);
	}
	
	
	public int getCredits() {
		return totalCredits;
	}
	
	
}
