package com.mentoringproject.hogwarts.labels.service;

import com.mentoringproject.hogwarts.common.service.HogwartsAbstractFactory;
import com.mentoringproject.hogwarts.labels.dao.HogwartsLabelDao;
import com.mentoringproject.hogwarts.labels.model.HogwartsLabelGreen;
import com.mentoringproject.hogwarts.labels.model.HogwartsLabelRed;
import com.mentoringproject.hogwarts.labels.model.HogwartsLabelYellow;
import com.mentoringproject.hogwarts.milestones.dao.HogwartsMilestoneDao;

public class HogwartsLabelFactory extends HogwartsAbstractFactory
{
	@Override
	public HogwartsLabelDao getLabel(final String Label)
	{
		 if(Label == null)
		 {
			 return null;
	     }		
	      
	     if(Label.equalsIgnoreCase("GREEN"))
	     {
	        return new HogwartsLabelGreen();
	         
	     }
	      
	     else if(Label.equalsIgnoreCase("RED"))
	     {
	        return new HogwartsLabelRed();
	         
	     }
	      
	     else if(Label.equalsIgnoreCase("YELLOW"))
	     {
	        return new HogwartsLabelYellow();
	     }
	      
	     return null;
	}
	
	@Override
	public HogwartsMilestoneDao getMilestone(final String milestone)
	{
		return null;
	}
}
