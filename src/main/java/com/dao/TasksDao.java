package com.dao;

import java.util.List;

import com.entities.Tasks;

public interface TasksDao {
	
	public boolean addTask(Tasks task);
	
	public boolean checkExistingTask(String taskName);
	
	public List<Tasks> viewAllTasks();   
	
	public boolean updateTask(Tasks oldTask, Tasks newTask); 
	
	public boolean deleteTask(Tasks task);
	
	public List<String> getTags();
	
	public List<String> getTaggedTasks(String tagName);

}
