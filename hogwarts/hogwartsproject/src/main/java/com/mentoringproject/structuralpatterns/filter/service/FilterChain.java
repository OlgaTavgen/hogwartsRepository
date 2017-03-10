package com.mentoringproject.structuralpatterns.filter.service;

import java.util.ArrayList;
import java.util.List;

import com.mentoringproject.structuralpatterns.filter.dao.FilterDao;

public class FilterChain
{
	private List<FilterDao> filters = new ArrayList<FilterDao>();
	private Target target;
	
	public void addFilter(FilterDao filter)
	{
		filters.add(filter);
	}
	
	public void execute(final String request)
	{
		for (FilterDao filter : filters)
		{
			filter.execute(request);
		}
		
		target.execute(request);
	}
	
	public void setTarget(Target target)
	{
		this.target = target;
	}
}
