package com.mentoringproject.hogwarts.settings.model;

public class HogwartsSettings
{
	private static HogwartsSettings settings = new HogwartsSettings();
	
	private HogwartsSettings()
	{
		
	}
	
	public static HogwartsSettings getSettings()
	{
		return settings;
	}	
}
