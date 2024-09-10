package academyMty.lmsf.final_project.model;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "task")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force=true)
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String title;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	public enum Status {
		TODO, DONE
	}
}
