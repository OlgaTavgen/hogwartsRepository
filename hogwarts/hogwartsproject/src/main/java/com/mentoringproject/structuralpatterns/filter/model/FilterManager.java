package com.mentoringproject.structuralpatterns.filter.model;

import com.mentoringproject.structuralpatterns.filter.dao.FilterDao;
import com.mentoringproject.structuralpatterns.filter.service.FilterChain;
import com.mentoringproject.structuralpatterns.filter.service.Target;
import com.sun.jersey.core.reflection.MethodList.Filter;

public class FilterManager
{
	FilterChain filterChain;
	
	public FilterManager(final Target target)
	{
		filterChain = new FilterChain();
		filterChain.setTarget(target);
	}
	
	public void setFilter(final FilterDao filter)
	{
		filterChain.addFilter(filter);
	}
	
	public void filterRequest(final String request)
	{
		filterChain.execute(request);
	}
}
