package com.mentoringproject.hogwarts.filters.model;

import com.mentoringproject.hogwarts.filters.dao.HogwartsFilterDao;

public class HogwartsFilter implements HogwartsFilterDao
{
	
	private String filterName;
	
	public HogwartsFilter(final String filterName) 
	{
		this.filterName = filterName;
	}

	@Override
	public void filter() 
	{
		// TODO Auto-generated method stub
		
	}
	
}
