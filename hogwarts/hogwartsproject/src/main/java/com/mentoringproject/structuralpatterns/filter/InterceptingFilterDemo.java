package com.mentoringproject.structuralpatterns.filter;

import com.mentoringproject.structuralpatterns.filter.model.Client;
import com.mentoringproject.structuralpatterns.filter.model.FilterManager;
import com.mentoringproject.structuralpatterns.filter.service.AuthenticationFilter;
import com.mentoringproject.structuralpatterns.filter.service.DebugFilter;
import com.mentoringproject.structuralpatterns.filter.service.Target;

public class InterceptingFilterDemo
{
	public void filter()
	{
		FilterManager filterManager = new FilterManager(new Target());
		filterManager.setFilter(new AuthenticationFilter());
		filterManager.setFilter(new DebugFilter());
		
		Client client = new Client();
		client.setFilterManager(filterManager);
		client.sendRequest("HOME");
	}
}
