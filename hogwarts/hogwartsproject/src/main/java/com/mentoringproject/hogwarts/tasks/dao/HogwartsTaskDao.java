package com.mentoringproject.hogwarts.tasks.dao;

import com.shared.model.tasks.Task;

public interface HogwartsTaskDao 
{
	public void addTask(Task task);
	
	public void deleteTask(Task task);
}
