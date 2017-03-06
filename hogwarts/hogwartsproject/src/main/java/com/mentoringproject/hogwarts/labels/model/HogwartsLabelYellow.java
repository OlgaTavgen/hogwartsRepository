package com.mentoringproject.hogwarts.labels.model;

import com.mentoringproject.hogwarts.labels.dao.HogwartsLabelDao;

public class HogwartsLabelYellow implements HogwartsLabelDao 
{

	@Override
	public void createLabel()
	{		
		System.out.println("Yellow Label");		
	}

}
