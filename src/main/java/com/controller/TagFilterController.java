package com.controller;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.TasksDao;
import com.miscellaneous.Config;

@Controller
public class TagFilterController {

	ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
	TasksDao tasksDao = context.getBean("tasksDao", TasksDao.class);
	
	@RequestMapping(value = "/tagFilter")
	public String tagFilter(Model model)
	{
		ArrayList<String> tagsList = (ArrayList<String>) tasksDao.getTags();
		
		if(tagsList.isEmpty())	
		{
			model.addAttribute("message", "There are no tasks available currently. Please add a task "
					+ "first.");
			return "home";
		}
		
		model.addAttribute("tagsList", tagsList);
		
		return "tagFilter";
	}
	
	@RequestMapping(value = "/processFilterTag")
	public String processFilterTag(@RequestParam("tagsList") String selectedTag,
			Model model)
	{
		ArrayList<String> tasksList =  (ArrayList<String>) tasksDao.getTaggedTasks(selectedTag);
		model.addAttribute("tasksList", tasksList);
		model.addAttribute("tagName", selectedTag);
		
		return "tagFilterResult";
	}
	
}
