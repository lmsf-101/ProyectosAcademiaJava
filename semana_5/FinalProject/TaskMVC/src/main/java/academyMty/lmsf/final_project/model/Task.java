package academyMty.lmsf.final_project.model;


import jakarta.persistence.*;
import lombok.*;

@Entity // Specify that the class is an entity
@Table(name = "task") // Sets the database table to which associate

// LOMBOK ANNOTATIONS
@Data // Generate getters, setters, toString and hashCode method, among other things...
@AllArgsConstructor // Sets up a constructor that requires an argument for each of the class fields
@NoArgsConstructor // Sets up an empty constructor
public class Task {
	
	// Primary key attribute
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	private String title;
	
	// Specify how the enum value should be persisted (in this case, treat it as a numerical value)
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	public enum Status {
		TODO, DONE
	}
}
