package com.mentoringproject.hogwarts.teams.model;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class HogwartsTeam
{
	private String id = StringUtils.EMPTY;
	private String name = StringUtils.EMPTY;
	private Set developers;
//	private Map tasks;
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public Set getDevelopers()
	{
		return developers;
	}

	public void setDevelopers(Set developers)
	{
		this.developers = developers;
	}

//	public Map getTasks() {
//		return tasks;
//	}
//
//	public void setTasks(Map tasks) {
//		this.tasks = tasks;
//	}

	@Override
	public String toString()
	{
		return "Team [id=" + id + ", name=" + name + ", developers=" + developers + "]";
	}
}
