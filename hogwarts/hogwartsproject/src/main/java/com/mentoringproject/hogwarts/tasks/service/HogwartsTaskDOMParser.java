package com.mentoringproject.hogwarts.tasks.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;

import com.shared.model.XMLTagsLocators;

@Component
public class HogwartsTaskDOMParser {
	
	public String id = StringUtils.EMPTY;
	public String type = StringUtils.EMPTY;
	public String description = StringUtils.EMPTY;
	public String estimate = StringUtils.EMPTY;
	public String priority = StringUtils.EMPTY;
	public String severity = StringUtils.EMPTY;
		
	public String getId()
	{
		return id;
	}

	public String getType()
	{
		return type;
	}

	public String getDescription()
	{
		return description;
	}

	public String getEstimate()
	{
		return estimate;
	}

	public String getPriority()
	{
		return priority;
	}

	public String getSeverity()
	{
		return severity;
	}

	public void parseTask(Element taskElement)
	{
		id = taskElement.getAttribute(XMLTagsLocators.TASK_ID_ATTR).toString();
		
		final Element typeElement = (Element) taskElement.getElementsByTagName(XMLTagsLocators.TASK_TYPE).item(0);
		type = typeElement.getFirstChild().getNodeValue();
		
		final Element descriptionElement = (Element) taskElement.getElementsByTagName(XMLTagsLocators.TASK_DESCRIPTION).item(0);
		description = descriptionElement.getFirstChild().getNodeValue();
		
		final Element estimateElement = (Element) taskElement.getElementsByTagName(XMLTagsLocators.TASK_ESTIMATE).item(0);
		estimate = estimateElement.getFirstChild().getNodeValue();
		
		final Element priorityElement = (Element) taskElement.getElementsByTagName(XMLTagsLocators.TASK_PRIORITY).item(0);
		priority = priorityElement.getFirstChild().getNodeValue();
		
		final Element severityElement = (Element) taskElement.getElementsByTagName(XMLTagsLocators.TASK_SEVERITY).item(0);
		severity = severityElement.getFirstChild().getNodeValue();
	}

}
