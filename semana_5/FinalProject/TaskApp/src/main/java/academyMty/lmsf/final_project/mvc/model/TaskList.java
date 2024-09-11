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
		for (TaskOffline taskOffline : list) {
			if (taskOffline.getID() == id)
					return taskOffline;
		}
		
		return null;
	}
	
	public void changeTask(int id, TaskOffline newTask) {
		int index = list.indexOf(getTaskById(id));
		
		list.set(index, newTask);
	}
	
}
