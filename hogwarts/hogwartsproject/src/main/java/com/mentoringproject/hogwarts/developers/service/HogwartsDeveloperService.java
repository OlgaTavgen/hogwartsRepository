package com.mentoringproject.hogwarts.developers.service;

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
import com.mentoringproject.hogwarts.common.model.HogwartsResultsResponse;
import com.mentoringproject.hogwarts.developers.dao.HogwartsDeveloperDao;
import com.mentoringproject.hogwarts.developers.model.HogwartsDeveloper;
import com.mentoringproject.hogwarts.tasks.dao.HogwartsTaskDao;
import com.mentoringproject.hogwarts.tasks.service.HogwartsTaskDOMParser;
import com.shared.model.XMLTagsLocators;
import com.shared.model.developers.Developer;
import com.shared.model.tasks.xml.Task;
import com.shared.model.teams.TeamEnum;

@Component
public class HogwartsDeveloperService extends HogwartsDeveloper
{
	@Autowired
	private HogwartsDeveloperDOMParser hogwartsDeveloperDOMParser;
	
	@Autowired
	private HogwartsDeveloperDao hogwartsDeveloperDao;
	
	private final static String DEVELOPERS_XML_PATH = "D:/REPOSITORIES/mentoringRepository/mentoringproject/src/main/resources/xml/developer.xml";
	
	public List<HogwartsDeveloper> createDevelopersFromXML(final HogwartsResultsResponse response)
	{
		List<HogwartsDeveloper> developers = Lists.newArrayList();
		
		try
		{						
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.parse(new File(DEVELOPERS_XML_PATH));
		
			NodeList teamsList = doc.getElementsByTagName(XMLTagsLocators.TEAM);
		
			for(int teamCount=0; teamCount<teamsList.getLength(); teamCount++)
			{
				Node teamNode = teamsList.item(teamCount);
				Element teamElement = (Element) teamNode;
			
				if(teamElement.getAttribute(XMLTagsLocators.TEAM_NAME_ATTR).equals(response.getTeam()))
				{
					final NodeList developersList = teamElement.getElementsByTagName(XMLTagsLocators.DEVELOPER);
					
					final HogwartsDeveloper  developer = new HogwartsDeveloper();
				
					for(int devCount=0; devCount<developersList.getLength(); devCount++)
					{
						Node developerNode = developersList.item(devCount);					
						Element developerElement = (Element)developerNode;

						try 
						{
							final HogwartsDeveloper developerClone = developer.clone();
							
							hogwartsDeveloperDOMParser.parseDeveloper(developerElement);
							
							final String firstName = hogwartsDeveloperDOMParser.getFirstName();
							final String lastName = hogwartsDeveloperDOMParser.getLastName();
							final String nickname = hogwartsDeveloperDOMParser.getNickname();
							final String primarySkill = hogwartsDeveloperDOMParser.getPrimarySkill();
							
							developerClone.updateDeveloperInfo(firstName, lastName, nickname, primarySkill);
							developers.add(developerClone);
						}						
						catch (CloneNotSupportedException e)
						{
							e.printStackTrace();
						}
					}					
				}		
			}
		
			return developers;			
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
		
		return developers;	
	}
	
	public void addDeveloper(final Developer developer, final TeamEnum team)
	{		
		hogwartsDeveloperDao.addDeveloper(developer, team);
	}
	
	public void deleteDeveloper(final Developer developer, final TeamEnum team)
	{		
		hogwartsDeveloperDao.deleteDeveloper(developer, team);
	}

}
