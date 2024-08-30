package builder;

import java.util.ArrayList;

public class FlexibleScheduleBuilder implements ScheduleBuilder{

	private int semester;
	private ArrayList<Course> courses;
	private int totalCredits;
	
	
	public FlexibleScheduleBuilder(int semester) {
		this.semester = semester;
		courses = new ArrayList<>();
		totalCredits = 0;
	}

	@Override
	public FlexibleScheduleBuilder addCourse(Course c) {
		courses.add(c);
		return this;
	}

	@Override
	public FlexibleScheduleBuilder setCredits() {
		courses.forEach(
				course -> totalCredits += course.getCredits()
		);
		return this;
	}
	
	public ClassSchedule getSchedule() {
		return new ClassSchedule(semester, courses, totalCredits);
	}

}
