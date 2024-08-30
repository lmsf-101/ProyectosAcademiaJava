package builder;

public interface ScheduleBuilder {
	<T extends ScheduleBuilder> T addCourse(Course c);
	<T extends ScheduleBuilder> T setCredits();
}
