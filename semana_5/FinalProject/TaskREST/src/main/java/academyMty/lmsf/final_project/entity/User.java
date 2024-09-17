package academyMty.lmsf.final_project.entity;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="users") // <- Table the entity should map to
// LOMBOK ANNOTATIONS
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	// UserID that represents the primary key of the table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false)
	private String password;
	
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy("task_id ASC") // Order the list of tasks by their IDs
	private List<Task> tasks = new ArrayList<>();
}
