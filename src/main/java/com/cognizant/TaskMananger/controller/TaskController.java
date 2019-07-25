package com.cognizant.TaskMananger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.TaskMananger.entity.Task;
import com.cognizant.TaskMananger.model.TaskObj;
import com.cognizant.TaskMananger.service.TaskService;

@CrossOrigin
@Controller
@RequestMapping(path = "/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewTask(@RequestBody TaskObj task) {

		return taskService.addNewTask(task);
	}

	@GetMapping(path = "/all")
	public @ResponseBody List<TaskObj> getAllTasks() {
		return taskService.getAllTasks();
	}

	@PutMapping(path = "/update")
	public @ResponseBody Task updateTask(@RequestBody TaskObj task) {

		return taskService.updateTask(task);
	}

	@PutMapping(path = "/end-task")
	public @ResponseBody Task endTask(@RequestBody TaskObj task) {

		return taskService.endTask(task);
	}

	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public @ResponseBody Iterable<TaskObj> getTasksByProject(@PathVariable("id") Long id) {

		return taskService.getTasksByProject(id);

	}

}
