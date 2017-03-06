package com.mentoringproject.hogwarts.tasks.model;

import org.apache.commons.lang.StringUtils;

import com.mentoringproject.hogwarts.common.service.HogwartsItem;

public class HogwartsTask implements HogwartsItem
{
	private String id = StringUtils.EMPTY;
	private String type = StringUtils.EMPTY;
	private String description = StringUtils.EMPTY;
	private String estimate = StringUtils.EMPTY;
	private String priority = StringUtils.EMPTY;
	private String severity = StringUtils.EMPTY;
	
	private String param = StringUtils.EMPTY;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() 
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getEstimate() {
		return estimate;
	}
	public void setEstimate(String estimate) {
		this.estimate = estimate;
	}
	
	public String getPriority()
	{
		return priority;
	}
	
	public void setPriority(String priority)
	{
		this.priority = priority;
	}
	
	public String getSeverity()
	{
		return severity;
	}
	
	public void setSeverity(String severity)
	{
		this.severity = severity;
	}
	
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}	

	@Override
	public void create(String... params) 
	{		
		for (final String param : params)		
		{
			this.setParam(param);
		}
	}
}
