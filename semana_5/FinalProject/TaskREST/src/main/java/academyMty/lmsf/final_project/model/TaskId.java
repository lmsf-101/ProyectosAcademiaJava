package academyMty.lmsf.final_project.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class TaskId implements Serializable {
	
	private int tId;
	private long uId;
	
	
	
}
