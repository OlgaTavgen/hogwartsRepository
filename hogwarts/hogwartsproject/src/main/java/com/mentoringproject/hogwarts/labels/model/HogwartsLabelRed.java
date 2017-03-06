package com.mentoringproject.hogwarts.labels.model;

import com.mentoringproject.hogwarts.labels.dao.HogwartsLabelDao;

public class HogwartsLabelRed implements HogwartsLabelDao
{

	@Override
	public void createLabel() 
	{		
		System.out.println("Red Label");
	}

}
