package com.mentoringproject.hogwarts.common.service;

import com.mentoringproject.hogwarts.labels.service.HogwartsLabelFactory;
import com.mentoringproject.hogwarts.milestones.service.HogwartsMilestoneFactory;

public class HogwartsFactoryProducer
{
	public static HogwartsAbstractFactory getFactory(final String choice)
	{
		if (choice.equalsIgnoreCase("LABEL"))
		{
			return new HogwartsLabelFactory();
		}
		
		else if (choice.equalsIgnoreCase("MILESTONE"))
		{
			return new HogwartsMilestoneFactory();
		}
		
		return null;
	}
}
