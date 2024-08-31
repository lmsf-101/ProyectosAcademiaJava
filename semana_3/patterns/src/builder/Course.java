package builder;

import java.util.Objects;

public class Course {
	
	private String code;
	private String name;
	private int credits;

	public Course(String code, String name, int credits) {
		this.code = code;
		this.name = name;
		this.credits = credits;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "["+ code + " - " + name + " (" + credits + " credits)]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, credits, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(code, other.code) && credits == other.credits && Objects.equals(name, other.name);
	}
	
	

}
