package com.mentoringproject.structuralpatterns.bridge.model;

import com.mentoringproject.structuralpatterns.bridge.dao.DrawAPI;

public abstract class Shape
{
	protected DrawAPI drawAPI;
	
	protected Shape(DrawAPI drawAPI)
	{
		this.drawAPI = drawAPI;
	}
	
	public abstract void draw();
}
