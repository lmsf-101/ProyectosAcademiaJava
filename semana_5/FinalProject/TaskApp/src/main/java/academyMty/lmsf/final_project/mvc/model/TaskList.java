package academyMty.lmsf.final_project.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
	
	private List<TaskOffline> list = new ArrayList<>();
	
	public void addTask(TaskOffline task) {
		list.add(task);
	}
	
	public List<TaskOffline> getTasks() {
		return list;
	}
	
	public TaskOffline getTaskById(int id) {
		return list.get(id);
	}
}
