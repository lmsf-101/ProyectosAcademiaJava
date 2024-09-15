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
	@Column(name = "task_id")
	private int tId;
	
	@JsonIgnore
	@Id
	@Column(name = "user_id")
	private long uId;
	
	private String title;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "ID", insertable = false, updatable = false)
	private User user;
	
	public enum Status {
		TODO, DONE
	}


	@Override
	public int compareTo(Task o) {
		return this.getStatus().compareTo(o.getStatus());
	}
}
