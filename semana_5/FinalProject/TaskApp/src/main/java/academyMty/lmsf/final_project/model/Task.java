package academyMty.lmsf.final_project.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tasks")
@Data
@IdClass(TaskId.class)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force=true)
public class Task implements Comparable<Task> {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tId;
	
	@Id
	private long uId;
	
	private String title;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "uId", referencedColumnName = "userID", insertable = false, updatable = false)
	private User user;
	
	public enum Status {
		TODO, DONE
	}


	@Override
	public int compareTo(Task o) {
		return this.getStatus().compareTo(o.getStatus());
	}
}
