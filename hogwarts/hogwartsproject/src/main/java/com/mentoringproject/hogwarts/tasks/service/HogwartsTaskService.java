package com.mentoringproject.hogwarts.tasks.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.common.collect.Lists;
import com.mentoringproject.hogwarts.common.service.HogwartsItem;
import com.mentoringproject.hogwarts.common.service.HogwartsItemFactory;
import com.mentoringproject.hogwarts.tasks.dao.HogwartsTaskDao;
import com.mentoringproject.hogwarts.tasks.model.HogwartsTask;
import com.shared.model.XMLTagsLocators;
import com.shared.model.tasks.Task;
import com.shared.model.tasks.TaskEnum;

@Component
public class HogwartsTaskService
{
	@Autowired
	private HogwartsItemFactory hogwartsItemFactory;
	
	@Autowired
	private HogwartsTaskDao hogwartsTaskDao;
	
	@Autowired
	private HogwartsTaskDOMParser hogwartsTaskDOMParser;
	
	private final static String TASKS_XML_PATH = "D:/REPOSITORIES/mentoringRepository/mentoringproject/src/main/resources/xml/task.xml";
	
	public List<HogwartsTask> createTasksFromXML()
	{
		List<HogwartsTask> tasks = Lists.newArrayList();
				
		try
		{						
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.parse(new File(TASKS_XML_PATH));
		
			NodeList tasksList = doc.getElementsByTagName(XMLTagsLocators.TASK);
		
			for(int taskCount=0; taskCount<tasksList.getLength(); taskCount++)
			{
				Node taskNode = tasksList.item(taskCount);
				Element taskElement = (Element) taskNode;
				
				final HogwartsItem item = hogwartsItemFactory.getItem("TASK");
				
//				final HogwartsTask task = new HogwartsTask();
				
				hogwartsTaskDOMParser.parseTask(taskElement);
				
				final String id = hogwartsTaskDOMParser.getId();
				final String type = hogwartsTaskDOMParser.getType();
				final String description = hogwartsTaskDOMParser.getDescription();
				final String estimate = hogwartsTaskDOMParser.getEstimate();
				final String priority = hogwartsTaskDOMParser.getPriority();
				final String severity = hogwartsTaskDOMParser.getSeverity();
				
				item.create(id, type, description, estimate, priority, severity);
					
				tasks.add((HogwartsTask) item);					
			}
		
			return tasks;	
		}
		
		catch(ParserConfigurationException pce)
		{
			pce.printStackTrace();
		}
		
		catch (SAXException se)
		{
			se.printStackTrace ();
		} 
		
		catch (IOException ioe)
		{
			ioe.printStackTrace ();
		} 
		
		return tasks;
	}
	
	public void addTask(final Task task)
	{		
		hogwartsTaskDao.addTask(task);
	}
	
	public void deleteTask(final Task task)
	{		
		hogwartsTaskDao.deleteTask(task);
	}
}
