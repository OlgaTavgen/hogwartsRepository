package com.mentoringproject.structuralpatterns.bridge;

import com.mentoringproject.structuralpatterns.bridge.model.Circle;
import com.mentoringproject.structuralpatterns.bridge.model.Shape;
import com.mentoringproject.structuralpatterns.bridge.service.GreenCircle;
import com.mentoringproject.structuralpatterns.bridge.service.RedCircle;

public class BridgePatternDemo 
{
	public static void drawShape()
	{
		Shape redCircle = new Circle(100, 100, 10, new RedCircle());
		Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());
		
		redCircle.draw();
		greenCircle.draw();
	}	
}
