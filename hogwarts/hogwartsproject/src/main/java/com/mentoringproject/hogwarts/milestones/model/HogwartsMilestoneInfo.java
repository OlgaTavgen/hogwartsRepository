package com.mentoringproject.hogwarts.milestones.model;

import com.mentoringproject.hogwarts.milestones.dao.HogwartsMilestoneDao;

public class HogwartsMilestoneInfo implements HogwartsMilestoneDao
{
	@Override
	public void createMilestone()
	{
		System.out.println("Info Milestone");		
	}
}
