package com.mentoringproject.hogwarts.graphs.service;

import com.mentoringproject.hogwarts.graphs.model.HogwartsGraphBar;
import com.mentoringproject.hogwarts.graphs.model.HogwartsGraphDiagram;
import com.mentoringproject.hogwarts.graphs.model.HogwartsGraphLinear;

public class HogwartsGraphFacade 
{
	private HogwartsGraphBar bar;
	private HogwartsGraphLinear linear;
	private HogwartsGraphDiagram diagram;
	
	public HogwartsGraphFacade()
	{
		bar = new HogwartsGraphBar();
		linear = new HogwartsGraphLinear();
		diagram = new HogwartsGraphDiagram();
	}
	
	public void createBar()
	{
		bar.createGraph();
	}
	
	public void createLinear()
	{
		linear.createGraph();
	}
	
	public void createDiagram()
	{
		diagram.createGraph();
	}
}
