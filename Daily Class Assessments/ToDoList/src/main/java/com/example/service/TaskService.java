package com.example.service;

import java.util.List;

import com.example.model.Task;

public interface TaskService {
	
	List<Task> getAllTasks();
	
	Task getTaskByID(Long id);
	
	Task saveTask(Task task);
	
	void deleteTask(Long id);

}