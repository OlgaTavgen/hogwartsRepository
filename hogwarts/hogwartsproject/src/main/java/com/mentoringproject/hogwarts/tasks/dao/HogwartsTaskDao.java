package com.mentoringproject.hogwarts.tasks.dao;

import org.springframework.stereotype.Component;

import com.shared.model.tasks.xml.Task;

@Component
public interface HogwartsTaskDao 
{
	public void addTask(Task task);
	
	public void deleteTask(Task task);
}
