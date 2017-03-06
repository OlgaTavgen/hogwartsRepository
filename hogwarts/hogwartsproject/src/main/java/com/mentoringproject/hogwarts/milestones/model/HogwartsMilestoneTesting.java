package com.mentoringproject.hogwarts.milestones.model;

import com.mentoringproject.hogwarts.milestones.dao.HogwartsMilestoneDao;

public class HogwartsMilestoneTesting implements HogwartsMilestoneDao
{
	@Override
	public void createMilestone() 
	{
		System.out.println("Testing Milestone");		
	}
}
