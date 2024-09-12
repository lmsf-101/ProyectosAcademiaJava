package academyMty.lmsf.final_project.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force=true)
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String title;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	@JsonBackReference
	@ManyToOne
	private User user;
	
	
	public enum Status {
		TODO, DONE
	}
}
