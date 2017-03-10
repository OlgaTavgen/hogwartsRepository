package com.mentoringproject.structuralpatterns.filter.model;

public class Client
{
	FilterManager filterManager;
	
	public void setFilterManager(final FilterManager filterManager)
	{
		this.filterManager = filterManager;
	}
	
	public void sendRequest(final String request)
	{
		filterManager.filterRequest(request);
	}
}
