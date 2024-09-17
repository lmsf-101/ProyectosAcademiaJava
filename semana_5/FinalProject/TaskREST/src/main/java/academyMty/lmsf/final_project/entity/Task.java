package academyMty.lmsf.final_project.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tasks")
@IdClass(TaskId.class) // <- Associate the Task entity with the TaskId composite key class
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force=true)
public class Task implements Comparable<Task> {
	
	@Id
	@Column(name = "task_id")
	private int tId;
	
	@JsonIgnore // Exclude the attribute from the JSON response of the app
	@Id
	@Column(name = "user_id")
	private long uId;
	
	// No need for the @Column annotation 
	private String title;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	
	// Set up the relationship with the User entity
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "ID", insertable = false, updatable = false)
	private User user;
	
	
	// Enumeration that specifies the state of the task object:
	public enum Status {
		TODO, DONE
	}

	// Comparable implementation that sorts the Task list by their status:
	@Override
	public int compareTo(Task o) {
		return this.getStatus().compareTo(o.getStatus());
	}
}
