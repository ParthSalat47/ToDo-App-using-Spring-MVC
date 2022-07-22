package com.entities;

import java.util.ArrayList;
import java.util.Arrays;

public class Tasks implements Comparable<Tasks>{

	private String taskName;
	private ArrayList<String> tags;
	
	// -------------------------------------------------
	
	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}
	
	public Tasks(String taskName, ArrayList<String> tags) {
		super();
		this.taskName = taskName;
		this.tags = tags;
	}
	
	public Tasks() {
		
	}
	
	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * @return the tags
	 */
	public ArrayList<String> getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Tasks [taskName=" + taskName + ", tags=" + tags + "]";
	}

	@Override
    public int compareTo(Tasks other) {
        return taskName.compareTo(other.taskName);
    }
	


	
}
