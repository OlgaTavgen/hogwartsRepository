package com.mentoringproject.hogwarts.common.service;

import org.springframework.stereotype.Component;

import com.mentoringproject.hogwarts.developers.model.HogwartsDeveloper;
import com.mentoringproject.hogwarts.tasks.model.HogwartsTask;

@Component
public class HogwartsItemFactory 
{
	public HogwartsItem getItem(String itemType)
	{
		if (itemType == null)
		{
			return null;
		}
		
		if (itemType.equalsIgnoreCase("DEVELOPER"))
		{
			return new HogwartsDeveloper();
		}
		
		if (itemType.equalsIgnoreCase("TASK"))
		{
			return new HogwartsTask();
		}
		
		return null;
	}
}
