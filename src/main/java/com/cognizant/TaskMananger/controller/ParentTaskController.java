package com.cognizant.TaskMananger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.TaskMananger.entity.ParentTask;
import com.cognizant.TaskMananger.service.ParentTaskService;
//import com.cognizant.projectmanagement.service.ParentTaskService;
@CrossOrigin
@Controller
@RequestMapping(path="/parenttask")
public class ParentTaskController {

	@Autowired
	private ParentTaskService parentTaskService;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<ParentTask> getAllParentTasks() {
		return parentTaskService.getAllUsers();
	}
	
	@PostMapping(path="/add")
	public @ResponseBody ParentTask addNew (@RequestParam String task) {
		return parentTaskService.addNew(task);
	}

}
