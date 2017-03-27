package com.mentoringproject.springcore;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Hogwarts
{
	private List teams;
	private Set developers;
	private Map taskMapping;
	private Properties props;

	public List getTeams()
	{
		return teams;
	}

	public void setTeams(List lists)
	{
		this.teams = lists;
	}
	
	public Set getDevelopers()
	{
		return developers;
	}

	public void setDevelopers(Set developers)
	{
		this.developers = developers;
	}

	public Map getTaskMapping() 
	{
		return taskMapping;
	}

	public void setTaskMapping(Map taskMapping) 
	{
		this.taskMapping = taskMapping;
	}

	public Properties getProps()
	{
		return props;
	}

	public void setProps(Properties props)
	{
		this.props = props;
	}

	public String toString()
	{
		return teams.toString();
	}
}
