package com.mentoringproject.hogwarts.teams.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hamcrest.object.HasToString;

import com.mentoringproject.hogwarts.developers.model.jpa.HogwartsDeveloperJPA;

@Entity
public class HogwartsTeamJPA
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String name;
	
	@ManyToOne
	private HogwartsDeveloperJPA developer;

	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public HogwartsDeveloperJPA getDeveloper() 
	{
		return developer;
	}

	public void setDeveloper(HogwartsDeveloperJPA developer) 
	{
		this.developer = developer;
	}

}
