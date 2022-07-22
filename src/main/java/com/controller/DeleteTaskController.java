package com.controller;

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
public class DeleteTaskController {

	ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
	TasksDao tasksDao = context.getBean("tasksDao", TasksDao.class);
	
	@RequestMapping(value = "/deleteTask")
	public String deleteTask(Model model)
	{
		
		List<Tasks> taskList = tasksDao.viewAllTasks();
		
		if(taskList.isEmpty())	
		{
			model.addAttribute("message", "There are no tasks available to delete. Please add a task "
					+ "first.");
			return "home";
		}
		
		model.addAttribute("taskList", taskList);  
		
		return "deleteTask";
	}
	
	@RequestMapping(value = "/processDeleteTask")
	public String processDeleteTask(@RequestParam("taskList") String taskName,
			Model model)
	{
		Tasks task = new Tasks();
		task.setTaskName(taskName);
		
		if(tasksDao.deleteTask(task))
		{
			model.addAttribute("result", "Deleted task successfully!");
		}
		else
		{
			model.addAttribute("result", "Failed to delete task. Please try after some time.");
		}	
		
		List<Tasks> taskList = tasksDao.viewAllTasks(); 
		
		if(taskList.isEmpty())	
		{
			model.addAttribute("message", "Deleted task successfully! \nYou currently have no "
					+ "tasks in this app.");
			return "home";
		}
		
		model.addAttribute("taskList", taskList);   
		
		return "deleteTask";
	}
	
}
