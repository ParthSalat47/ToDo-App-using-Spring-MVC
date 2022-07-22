package com.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.TasksDao;
import com.entities.Tasks;
import com.miscellaneous.Config;

@Controller
public class UpdateTaskController {
	
	ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
	TasksDao tasksDao = context.getBean("tasksDao", TasksDao.class);
	
	@RequestMapping(value = "/updateTask")
	public String updateTaskPage(Model model)
	{
		List<Tasks> taskList = tasksDao.viewAllTasks(); 
		
		if(taskList.isEmpty())	
		{
			model.addAttribute("message", "There are no tasks available to update. Please add a task "
					+ "first.");
			return "home";
		}
		
		model.addAttribute("taskList", taskList);  
		
		return "updateTask";
	}
	
	@RequestMapping(value = "/processUpdateTask")
	public String processUpdateTaskPage(@RequestParam("taskName") String newTaskName, 
			@RequestParam("taskList") String oldTaskName, 
			@RequestParam("tags") String tags, Model model)
	{		
		if(tasksDao.checkExistingTask(newTaskName))	
		{
			model.addAttribute("result", "This task name already exists! Please update the existing"
					+ " task or enter a new task name.");
			
			List<Tasks> taskList = tasksDao.viewAllTasks(); 
			model.addAttribute("taskList", taskList);
			
			return "updateTask";
		}
		
		ArrayList<String> tagsList = new ArrayList<String>();
		
		String tagsWithSpaces[] = tags.split(",");
		for(String tag : tagsWithSpaces) 
		{
			tagsList.add(tag.replaceAll("\\s", ""));		//replaceAll is used to remove spaces  
		}
		
		Tasks oldTask = new Tasks(); 
		Tasks newTask = new Tasks(); 
		
		oldTask.setTaskName(oldTaskName); 
		newTask.setTaskName(newTaskName);
		newTask.setTags(tagsList);
		
		if(tasksDao.updateTask(oldTask, newTask)) 
		{
			model.addAttribute("result", "Updated task successfully!");
		}
		else
		{
			model.addAttribute("result", "Failed to update task. Please try after some time.");
		}
		
		List<Tasks> taskList = tasksDao.viewAllTasks(); 
		model.addAttribute("taskList", taskList);
		
		return "updateTask";
	}
	
}
