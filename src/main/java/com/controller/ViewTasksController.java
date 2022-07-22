package com.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.TasksDao;
import com.entities.Tasks;
import com.miscellaneous.Config;

@Controller
public class ViewTasksController {

	ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
	TasksDao tasksDao = context.getBean("tasksDao", TasksDao.class);
	
	@RequestMapping(value = "/viewTasks")
	public String viewTasks(Model model)
	{
		List<Tasks> taskList = tasksDao.viewAllTasks(); 
		
		if(taskList.isEmpty())	
		{
			model.addAttribute("message", "There are no tasks available to view. Please add a task "
					+ "first.");
			return "home";
		}
		
		model.addAttribute("taskList", taskList);  
		
		return "viewTasks";
	}
	
}
