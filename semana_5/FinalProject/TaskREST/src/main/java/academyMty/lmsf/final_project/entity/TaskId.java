package academyMty.lmsf.final_project.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TaskId implements Serializable {
	
	private int tId;
	private long uId;
	
	
	
}
