package academyMty.lmsf.final_project.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false)
	private String password;
	
	@JsonIgnore
	@JsonManagedReference
	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	//@JoinColumn(name="user")
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy("task_id ASC")
	private List<Task> tasks;
}
