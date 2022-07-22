package com.miscellaneous;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.dao.TasksDaoImpl;

@Configuration
public class Config {

	@Bean("dataSource")
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/toDoTasks");
		dataSource.setUsername("root");
		dataSource.setPassword("root"); 
		return dataSource;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate; 
	}
	
	@Bean("tasksDao")
	public TasksDaoImpl getTasksDao()
	{
		TasksDaoImpl dao = new TasksDaoImpl();   
		dao.setJdbcTemplate(getTemplate());
		return dao;
	}
	
}






