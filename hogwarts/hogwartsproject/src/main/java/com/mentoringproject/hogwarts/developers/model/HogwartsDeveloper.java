package com.mentoringproject.hogwarts.developers.model;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:src/main/resources/beans-props.properties")
public class HogwartsDeveloper {

	private String firstName = StringUtils.EMPTY;
	private String lastName = StringUtils.EMPTY;
	private String nickname = StringUtils.EMPTY;
	private String primarySkill = StringUtils.EMPTY;
	
	@Value("${developerLevel}")
	private String level;
	
	private Map tasks;
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getNickname()
	{
		return nickname;
	}
	
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	
	public String getPrimarySkill()
	{
		return primarySkill;
	}
	
	public void setPrimarySkill(String primarySkill)
	{
		this.primarySkill = primarySkill;
	}
	
	public Map getTasks() 
	{
		return tasks;
	}

	public void setTasks(Map tasks) 
	{
		this.tasks = tasks;
	}

	public String getLevel() 
	{
		return level;
	}

	public void setLevel(String level)
	{
		this.level = level;
	}

	@Override
	public String toString()
	{
		return "Developer [firstName=" + firstName + ", lastName=" + lastName + ", nickname=" + nickname + ", primarySkill=" + primarySkill + ", level=" + level + ", tasks=" + tasks + "]";
	}
}
