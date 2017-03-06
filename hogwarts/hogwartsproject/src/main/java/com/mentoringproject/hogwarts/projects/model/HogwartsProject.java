package com.mentoringproject.hogwarts.projects.model;

public class HogwartsProject
{
	private final String projectName;
	private final String description;
	private final String startDate;
	private final String endDate;
	private final String team;	
	private final String goal;
	
	private HogwartsProject(HogwartsProjectBuilder builder)
	{
		this.projectName = builder.projectName;
		this.description = builder.description;
		this.startDate = builder.startDate;
		this.endDate = builder.endDate;
		this.team = builder.team;
		this.goal = builder.goal;
	}

	public String getProjectName() 
	{
		return projectName;
	}

	public String getStartDate() 
	{
		return startDate;
	}

	public String getEndDate()
	{
		return endDate;
	}

	public String getTeam()
	{
		return team;
	}

	public String getDescription()
	{
		return description;
	}

	public String getGoal()
	{
		return goal;
	}	
	
	public static class HogwartsProjectBuilder
	{
		private String projectName;
		private String description;
		private String startDate;
		private String endDate;
		private String team;		
		private String goal;
		
		public HogwartsProjectBuilder(String projectName, String description, String startDate, String endDate)
		{
			this.projectName = projectName;
			this.description = description;
			this.startDate = startDate;
			this.endDate = endDate;
		}
		
		public HogwartsProjectBuilder team(String team)
		{
			this.team = team;
			return this;		
		}
		
		public HogwartsProjectBuilder goal(String goal)
		{
			this.goal = goal;
			return this;		
		}
		
		public HogwartsProject build()
		{
			return new HogwartsProject(this);
		}
	}
}
