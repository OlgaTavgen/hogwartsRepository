package com.mentoringproject.hogwarts.developers.web;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import com.mentoringproject.hogwarts.developers.model.HogwartsDeveloper;
import com.mentoringproject.hogwarts.developers.model.HogwartsDeveloperItem;

public class HogwartsDeveloperItemDTO {
	
	@JsonProperty
	private List<HogwartsDeveloperDTO> developers = Lists.newArrayList();
	
	public HogwartsDeveloperItemDTO(final HogwartsDeveloperItem item)
	{
		final List<HogwartsDeveloperDTO> devDTOs = Lists.newArrayList();
		
		for (final HogwartsDeveloper  developer : item.getDevelopers())
		{			
			final HogwartsDeveloperDTO developerDTO = new HogwartsDeveloperDTO(developer);
			
			devDTOs.add(developerDTO);			
		}
		
		developers = devDTOs;			
	}
	
	public List<HogwartsDeveloperDTO> getDevelopers()
	{
		return developers;
	}
}
