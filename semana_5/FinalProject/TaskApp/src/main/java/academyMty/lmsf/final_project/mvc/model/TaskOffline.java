package academyMty.lmsf.final_project.mvc.model;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskOffline {
	
	private int ID;
	private String title;

	private Status status;
	
	public enum Status {
		TODO, DONE
	}
}
