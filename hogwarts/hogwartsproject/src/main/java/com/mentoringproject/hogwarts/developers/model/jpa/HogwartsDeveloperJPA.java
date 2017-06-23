package com.mentoringproject.hogwarts.developers.model.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class HogwartsDeveloperJPA
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String lastName;
	
	private String firstName;	
	private String nickname;
	private String primarySkill;
	private String level;
	
	public HogwartsDeveloperJPA()
	{		
	}

	public HogwartsDeveloperJPA(String firstName, String lastName, String nickname, String primarySkill)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickname = nickname;
		this.primarySkill = primarySkill;
	}
	
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

	public String getLevel() 
	{
		return level;
	}

	public void setLevel(String level)
	{
		this.level = level;
	}
}
