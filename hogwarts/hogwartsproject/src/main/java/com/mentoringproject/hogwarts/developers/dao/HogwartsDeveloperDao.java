package com.mentoringproject.hogwarts.developers.dao;

import org.springframework.stereotype.Component;

import com.shared.model.developers.Developer;
import com.shared.model.teams.TeamEnum;

@Component
public interface HogwartsDeveloperDao
{
	
	public void addDeveloper(Developer developer, TeamEnum team);
	
	public void deleteDeveloper(Developer developer, TeamEnum team);

}
