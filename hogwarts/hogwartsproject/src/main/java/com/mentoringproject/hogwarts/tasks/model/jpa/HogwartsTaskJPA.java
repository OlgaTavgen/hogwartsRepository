package com.mentoringproject.hogwarts.tasks.model.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class HogwartsTaskJPA
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	private String type;	
	private String description;
	private String estimate;
	private String priority;
	private String severity;
	
	public HogwartsTaskJPA()
	{		
	}

	public HogwartsTaskJPA(final String id, final String type, final String description,
			final String estimate,final String priority, final String severity)
	{
		this.id = id;
		this.type = type;
		this.description = description;
		this.estimate = estimate;
		this.priority = priority;
		this.severity = severity;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
{
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

	public String getEstimate()
	{
		return estimate;
	}

	public void setEstimate(String estimate)
	{
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
	
}
