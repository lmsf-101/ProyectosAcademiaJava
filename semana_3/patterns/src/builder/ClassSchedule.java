package builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClassSchedule {
	
	public static final int MIN_AMOUNT_CREDITS = 8;
	
	private int semester;
	private ArrayList<Course> courses;
	private int totalCredits;
	
	
	public ClassSchedule(int semester, List<Course> courses, int totalCredits) {
		this.semester = semester;
		this.courses = new ArrayList<>(courses);
		this.totalCredits = totalCredits;
	}
	
	
	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}


	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public int getCredits() {
		return totalCredits;
	}

	
	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}




	@Override
	public int hashCode() {
		return Objects.hash(courses, semester, totalCredits);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassSchedule other = (ClassSchedule) obj;
		return Objects.equals(courses, other.courses) && semester == other.semester
				&& totalCredits == other.totalCredits;
	}


	@Override
	public String toString() {
		return "ClassSchedule [semester=" + semester + ", courses=" + courses + ", totalCredits=" + totalCredits + "]";
	}
	
	
	
	
	
	
	
}
