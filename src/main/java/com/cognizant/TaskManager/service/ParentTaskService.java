package com.cognizant.TaskManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.TaskManager.entity.ParentTask;
import com.cognizant.TaskManager.repository.ParentTaskRepository;

@Service
public class ParentTaskService {
	
	@Autowired
	private ParentTaskRepository repo;
	

	public Iterable<ParentTask> getAllUsers() {
		return repo.findAll();
	}
	
	

	public ParentTask addNew(String task) {
		ParentTask ptask = new ParentTask();
		ptask.setParentTask(task);
		return repo.save(ptask);
	}
	

}
