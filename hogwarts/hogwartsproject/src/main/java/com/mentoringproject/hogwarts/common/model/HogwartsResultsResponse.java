package com.mentoringproject.hogwarts.common.model;

import com.mentoringproject.hogwarts.developers.model.HogwartsDeveloperItem;
import com.mentoringproject.hogwarts.tasks.model.HogwartsTaskItem;

public class HogwartsResultsResponse {
	
	private String team;
	
	private HogwartsDeveloperItem developerItem;
	
	private HogwartsTaskItem taskItem;
	
	//need to set a team name from UI somehow
	public HogwartsResultsResponse(final String team)
	{
		this.team = team;
	}

	public String getTeam()
	{
		return team;
	}

	public HogwartsDeveloperItem getDeveloperItem() 
	{
		return developerItem;
	}

	public void setDeveloperItem(HogwartsDeveloperItem developers) 
	{
		this.developerItem = developers;
	}

	public HogwartsTaskItem getTaskItem() 
	{
		return taskItem;
	}

	public void setTaskItem(HogwartsTaskItem tasks)
	{
		this.taskItem = tasks;
	}	
}