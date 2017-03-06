package com.mentoringproject.hogwarts.developers.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;

import com.shared.model.XMLTagsLocators;

@Component
public class HogwartsDeveloperDOMParser 
{
	public String firstName = StringUtils.EMPTY;
	public String lastName = StringUtils.EMPTY;
	public String nickname = StringUtils.EMPTY;
	public String primarySkill = StringUtils.EMPTY;
	
	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getNickname()
	{
		return nickname;
	}

	public String getPrimarySkill()
	{
		return primarySkill;
	}

	public void parseDeveloper(Element developerElement)
	{
		final Element firstNameElement = (Element) developerElement.getElementsByTagName(XMLTagsLocators.DEVELOPER_FIRSTNAME).item(0);
		firstName = firstNameElement.getFirstChild().getNodeValue();
									
		final Element lastNameElement = (Element) developerElement.getElementsByTagName(XMLTagsLocators.DEVELOPER_LASTNAME).item(0);
		lastName = lastNameElement.getFirstChild().getNodeValue();
									
		final Element nicknameElement = (Element) developerElement.getElementsByTagName(XMLTagsLocators.DEVELOPER_NICKNAME).item(0);
		nickname = nicknameElement.getFirstChild().getNodeValue();
									
		final Element primarySkillElement = (Element) developerElement.getElementsByTagName(XMLTagsLocators.DEVELOPER_PRIMARYSKILL).item(0);
		primarySkill = primarySkillElement.getFirstChild().getNodeValue();
	}

}
