package com.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.entities.Tasks;
import com.miscellaneous.Utility;

public class TasksDaoImpl implements TasksDao{
	
	private JdbcTemplate jdbcTemplate;

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean addTask(Tasks task) {
		
		String query = "insert into todotaskitems values ('TempUser', ?);";
		int count = this.jdbcTemplate.update(query, task.getTaskName());
		
		for(String tagName : task.getTags())
		{
			query = "insert into todoTags values (?, ?);";
			this.jdbcTemplate.update(query, task.getTaskName(),tagName);
		}
		
		//System.out.println(count + " row(s) inserted.");
		
		return true;
	}
	
	public boolean checkExistingTask(String taskName)
	{
		String query = "select taskname from todotaskitems "
				+ "where taskname = ? ;";
		
		List<String> tasksList = this.jdbcTemplate.query(query, new RowMapperImplDuplicateTask(), taskName);
		
		if(tasksList.size() > 0 )			return true;
		else 		return false;
	}

	
	public List<Tasks> viewAllTasks() {
		String query = "select tag.taskname , tag.tag "
				+ "from todotaskitems as task inner join todotags as tag "
				+ "on task.taskname = tag.taskname;";
		
		List<Tasks> tasksList = this.jdbcTemplate.query(query, new RowMapperImpl());
		tasksList = Utility.rectifyTaskList(tasksList);
		//System.out.println("\nrectified list: \n" + tasksList);
		return tasksList;
	}

	public boolean updateTask(Tasks oldTask, Tasks newTask) {
		String query = "update todotaskitems "
				+ "set taskname = ? "
				+ "where taskname = ? ;"; 
		this.jdbcTemplate.update(query, newTask.getTaskName(), oldTask.getTaskName()); 
		
		// Normal update would update all rows. Hence we need to delete first then insert.
		
		query = "delete from todoTags "
				+ "where taskname = ? ;";
		this.jdbcTemplate.update(query, oldTask.getTaskName());
		
		for(String tagName : newTask.getTags())
		{
			query = "insert into todoTags values (?, ?);";
			this.jdbcTemplate.update(query, newTask.getTaskName(), tagName);
		}
		
//		for(String tagName : newTask.getTags())
//		{
//			query = "update todoTags "
//					+ "set tag = ? , taskname = ? "
//					+ "where taskname = ? ;"; 
//			this.jdbcTemplate.update(query, tagName, newTask.getTaskName(), 
//					oldTask.getTaskName()); 
//		}	 
		
		return true;
	}

	public boolean deleteTask(Tasks task) {
		String query = "delete from todotaskitems "
				+ "where taskname = ? ;";
		this.jdbcTemplate.update(query, task.getTaskName());
		
		query = "delete from todoTags "
				+ "where taskname = ? ;";
		this.jdbcTemplate.update(query, task.getTaskName());
		
		//System.out.println(count + " row(s) deleted."); 		 
		
		return true;
	}
	
	public List<String> getTags() {
		String query = "select distinct tag from todoTags;";
		List<String> tagsList = this.jdbcTemplate.query(query, new RowMapperImplTags());
		return tagsList;
	}
	
	public List<String> getTaggedTasks(String tagName) {
		String query = "select TaskName from todoTags "
				+ "where tag = ? ;";
		List<String> tasksList = this.jdbcTemplate.query(query, new RowMapperImplTasks(), 
				tagName);
		return tasksList;
	}

}
