package com.mentoringproject.hogwarts.common.service;

import com.mentoringproject.hogwarts.labels.dao.HogwartsLabelDao;
import com.mentoringproject.hogwarts.milestones.dao.HogwartsMilestoneDao;

public abstract class HogwartsAbstractFactory
{
	public abstract HogwartsLabelDao getLabel(final String label);
	public abstract HogwartsMilestoneDao getMilestone(final String milestone);
}
