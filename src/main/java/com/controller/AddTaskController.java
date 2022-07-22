package com.controller;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.TasksDao;
import com.entities.Tasks;
import com.miscellaneous.Config;

@Controller
public class AddTaskController {
	
	@RequestMapping(value = "/addTask")
	public String addTaskPage()
	{
		return "addTask";
	}
	
	@RequestMapping(value = "/processAddTask")
	public String processAddTaskPage(@RequestParam("taskName") String taskName, 
			@RequestParam("tags") String tags, Model model)
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		TasksDao tasksDao = context.getBean("tasksDao", TasksDao.class);
		
		if(tasksDao.checkExistingTask(taskName))	
		{
			model.addAttribute("result", "This task name already exists! Please update the existing"
					+ " task or enter a new task name.");
			
			return "addTask";
		}
		
		Tasks task = new Tasks();
		ArrayList<String> tagsList = new ArrayList<String>();
		
		String tagsWithSpaces[] = tags.split(",");
		for(String tag : tagsWithSpaces) 
		{
			tagsList.add(tag.replaceAll("\\s", ""));		//replaceAll is used to remove spaces  
		}
		
		task.setTaskName(taskName);
		task.setTags(tagsList); 
		
		if(tasksDao.addTask(task))
		{
			model.addAttribute("result", "Added task successfully!");
		}
		else 
		{
			model.addAttribute("result", "Failed to add task. Please try after some time.");
		}
		
		return "addTask";
		
	}
	

}
