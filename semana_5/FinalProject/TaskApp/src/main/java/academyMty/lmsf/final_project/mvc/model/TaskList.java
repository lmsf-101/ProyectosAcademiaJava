package academyMty.lmsf.final_project.mvc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskList {
	
	private List<TaskOffline> list = new ArrayList<>();
	
	public void addTask(TaskOffline task) {
		list.add(task);
		orderList();
	}
	
	public List<TaskOffline> getTasks() {
		orderList();
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
		
		orderList();
	}
	
	public void deleteTask(int id) {
		int index = list.indexOf(getTaskById(id));
		
		list.remove(index);
		
		orderList();
	}
	
	private void orderList() {
		Collections.sort(list, (t1, t2) -> t1.getStatus().compareTo(t2.getStatus()));
	}
	
}
