package com.mentoringproject.structuralpatterns.flyweight.service;

import java.util.HashMap;

import com.mentoringproject.structuralpatterns.flyweight.dao.ShapeDao;
import com.mentoringproject.structuralpatterns.flyweight.model.Circle;

public class ShapeFactory 
{
	private static final HashMap<String, ShapeDao> circleMap = new HashMap();
	
	public static ShapeDao getCircle(final String color)
	{
		Circle circle = (Circle) circleMap.get(color);
		
		if (circle == null)
		{
			circle = new Circle(color);
			circleMap.put(color, circle);			
		}
		
		return circle;
	}
}
