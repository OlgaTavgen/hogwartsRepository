package com.mentoringproject.structuralpatterns.flyweight.model;

import com.mentoringproject.structuralpatterns.flyweight.dao.ShapeDao;

public class Circle implements ShapeDao
{
	private String color;
	private int x;
	private int y;
	private int radius;
	
	public Circle(final String color)
	{
		this.color = color;
	}	

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y) 
	{
		this.y = y;
	}

	public void setRadius(int radius)
	{
		this.radius = radius;
	}

	@Override
	public void draw() 
	{
		// TODO Auto-generated method stub		
	}

}
