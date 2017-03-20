package com.shared.model.tasks.db;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


import com.shared.model.tasks.xml.TaskEnum;

import io.spring.guides.gs_producing_web_service.Task;

@Component
public class HogwartsTaskRepository {
	
	private static final List<Task> tasks = new ArrayList<Task>();
	
	@PostConstruct
	public void initData()
	{		
		Task task1 = new Task();
		task1.setType(TaskEnum.TASK1.getType());
		task1.setDescription(TaskEnum.TASK1.getDescription());
		task1.setEstimate(TaskEnum.TASK1.getEstimate());
		task1.setPriority(TaskEnum.TASK1.getPriority());
		task1.setSeverity(TaskEnum.TASK1.getSeverity());

		tasks.add(task1);

		Task task2 = new Task();
		task2.setType(TaskEnum.TASK2.getType());
		task2.setDescription(TaskEnum.TASK2.getDescription());
		task2.setEstimate(TaskEnum.TASK2.getEstimate());
		task2.setPriority(TaskEnum.TASK2.getPriority());
		task2.setSeverity(TaskEnum.TASK2.getSeverity());

		tasks.add(task2);

		Task task3 = new Task();
		task3.setType(TaskEnum.TASK3.getType());
		task3.setDescription(TaskEnum.TASK3.getDescription());
		task3.setEstimate(TaskEnum.TASK3.getEstimate());
		task3.setPriority(TaskEnum.TASK3.getPriority());
		task3.setSeverity(TaskEnum.TASK3.getSeverity());

		tasks.add(task3);
	}
	
	public Task findTask(String type) {
		Assert.notNull(type);

		Task result = null;

		for (Task task : tasks) {
			if (type.equals(task.getType())) {
				result = task;
			}
		}

		return result;
	}

}
