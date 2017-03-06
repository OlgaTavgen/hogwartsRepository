package com.mentoringproject.hogwarts.milestones.service;

import com.mentoringproject.hogwarts.common.service.HogwartsAbstractFactory;
import com.mentoringproject.hogwarts.labels.dao.HogwartsLabelDao;
import com.mentoringproject.hogwarts.labels.model.HogwartsLabelGreen;
import com.mentoringproject.hogwarts.labels.model.HogwartsLabelRed;
import com.mentoringproject.hogwarts.labels.model.HogwartsLabelYellow;
import com.mentoringproject.hogwarts.milestones.dao.HogwartsMilestoneDao;
import com.mentoringproject.hogwarts.milestones.model.HogwartsMilestoneDevelopment;
import com.mentoringproject.hogwarts.milestones.model.HogwartsMilestoneInfo;
import com.mentoringproject.hogwarts.milestones.model.HogwartsMilestoneTesting;

public class HogwartsMilestoneFactory extends HogwartsAbstractFactory
{
	@Override
	public HogwartsMilestoneDao getMilestone(final String milestone)
	{
		 if(milestone == null)
		 {
			 return null;
	     }		
	      
	     if(milestone.equalsIgnoreCase("DEVELOPMENT"))
	     {
	        return new HogwartsMilestoneDevelopment();
	         
	     }
	      
	     else if(milestone.equalsIgnoreCase("INFO"))
	     {
	        return new HogwartsMilestoneInfo();
	         
	     }
	      
	     else if(milestone.equalsIgnoreCase("TESTING"))
	     {
	        return new HogwartsMilestoneTesting();
	     }
	      
	     return null;
	}
	
	@Override
	public HogwartsLabelDao getLabel(final String label)
	{
		return null;
	}
}
