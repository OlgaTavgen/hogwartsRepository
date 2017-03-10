package com.mentoringproject.hogwarts.filters.model;

import com.mentoringproject.hogwarts.filters.dao.HogwartsFilterDao;

public class HogwartsProxyFilter implements HogwartsFilterDao
{
	private  HogwartsFilter hogwartsFilter;
	private String filterName;
	
	public HogwartsProxyFilter(final String filterName)
	{
		this.filterName = filterName;
	}

	@Override
	public void filter() 
	{
		if (hogwartsFilter == null)
		{
			hogwartsFilter = new HogwartsFilter(filterName);
		}
		hogwartsFilter.filter();
	}
	
}
