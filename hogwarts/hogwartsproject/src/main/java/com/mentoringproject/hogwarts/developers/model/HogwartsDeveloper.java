package com.mentoringproject.hogwarts.developers.model;

import org.apache.commons.lang.StringUtils;

import com.mentoringproject.hogwarts.common.service.HogwartsItem;
import com.shared.model.developers.Developer;

public class HogwartsDeveloper implements Cloneable, HogwartsItem {

	private String firstName = StringUtils.EMPTY;
	private String lastName = StringUtils.EMPTY;
	private String nickname = StringUtils.EMPTY;
	private String primarySkill = StringUtils.EMPTY;
	
	private String param = StringUtils.EMPTY;
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getNickname()
	{
		return nickname;
	}
	
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	
	public String getPrimarySkill()
	{
		return primarySkill;
	}
	
	public void setPrimarySkill(String primarySkill)
	{
		this.primarySkill = primarySkill;
	}
	
	@Override
	public HogwartsDeveloper clone() throws CloneNotSupportedException
	{
		HogwartsDeveloper copy = (HogwartsDeveloper) super.clone();
		
		return copy;
	}
	
	public void updateDeveloperInfo(String firstName, String lastName, String nickname, String primarySkill)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickname = nickname;
		this.primarySkill = primarySkill;		
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
