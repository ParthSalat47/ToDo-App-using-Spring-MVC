package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.RowMapper;

import com.entities.Tasks;

public class RowMapperImpl implements RowMapper<Tasks>{
 
	ArrayList<Tasks> allTasks = new ArrayList<Tasks>();
	
	public Tasks mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		//System.out.println(rs.getString(1) + " DEBUG " + rs.getString(2));  
		
		for(Tasks currentTask : allTasks)
		{
			if(currentTask.getTaskName() == rs.getString(1))
			{
				ArrayList<String> currentTags = currentTask.getTags();
				currentTags.add(rs.getString(2));
				currentTask.setTags(currentTags);
				return currentTask;
			}
		}
		
		Tasks task = new Tasks();
		
		task.setTaskName(rs.getString(1));
		
		ArrayList<String> tagList = new ArrayList<String>();
		tagList.add(rs.getString(2));
		task.setTags(tagList);
		
		allTasks.add(task);
		
		return task; 
	}

	
	
	
	
}
