package builder;

public class Student {
	private final int ID;
	private String name;
	private ClassSchedule currentSchedule;
	
	private static int numStudents = 2743662;
	
	public Student(String name) {
		ID = ++numStudents;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClassSchedule getCurrentSchedule() {
		return currentSchedule;
	}

	public void setCurrentSchedule(ClassSchedule currentSchedule) {
		this.currentSchedule = currentSchedule;
	}

	public int getID() {
		return ID;
	}
	
	
}
