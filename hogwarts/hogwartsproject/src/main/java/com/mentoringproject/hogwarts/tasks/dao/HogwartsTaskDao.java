package com.mentoringproject.hogwarts.tasks.dao;

import java.util.List;

import com.shared.model.tasks.Task;

public interface HogwartsTaskDao 
{
	void addTask(Task task);
	
	void deleteTask(Task task);
	
	List<Task> getTasks();
}
