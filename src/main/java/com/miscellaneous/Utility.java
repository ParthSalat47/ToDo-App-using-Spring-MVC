package com.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.entities.Tasks;

public class Utility {
	
	public static ArrayList<Tasks> rectifyTaskList (List<Tasks> taskList)
	{
		if(taskList.size() == 0 || taskList.size() == 1) 		
			return (ArrayList<Tasks>) taskList; 
		
		Collections.sort(taskList);
		
		ArrayList<Tasks> rectifiedTasks = new ArrayList<Tasks>();
		ArrayList<String> tagsList = new ArrayList<String>();
		String tempTaskName = null;
		int count = taskList.size();
		int index = 0;
		
		while(index < count)		
		{
			Tasks tempTask = taskList.get(index);
			tempTaskName = tempTask.getTaskName();
			
			tagsList.addAll(tempTask.getTags()); 
			
			if(index == count-1)		break;
			
			while(index<count-1)
			{
				index++;
				Tasks secondTask = taskList.get(index);
				String secondTaskName = secondTask.getTaskName();
				
				if(tempTaskName.equals(secondTaskName))
				{
					tagsList.addAll(secondTask.getTags()); 
					continue;
				}
				else
				{
					Tasks newTask = new Tasks();
					newTask.setTaskName(tempTaskName);
					newTask.setTags(tagsList); 
					rectifiedTasks.add(newTask);
					tagsList = new ArrayList<String>();
					
					break;
				}
			}
	
		}
		
		//For adding the last task
		Tasks newTask = new Tasks();
		newTask.setTaskName(tempTaskName);
		newTask.setTags(tagsList); 
		rectifiedTasks.add(newTask);
		tagsList = new ArrayList<String>();
		
		return rectifiedTasks;
	}

}
