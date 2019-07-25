package com.cognizant.TaskMananger.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.TaskMananger.entity.ParentTask;
import com.cognizant.TaskMananger.entity.Project;
import com.cognizant.TaskMananger.entity.Task;
import com.cognizant.TaskMananger.entity.User;
import com.cognizant.TaskMananger.model.TaskObj;
import com.cognizant.TaskMananger.repository.ParentTaskRepository;
import com.cognizant.TaskMananger.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepo;

	@Autowired
	private ParentTaskRepository repo;


	public String addNewTask(TaskObj task) {
		if (task.isParentTask()) {
			ParentTask pTask = new ParentTask();
			pTask.setParentTask(task.getTaskName());
			repo.save(pTask);
		} else {
			Task t = new Task();
			if (null != task.getParentTaskId()) {
				ParentTask parentTask = new ParentTask();
				parentTask.setParentId(task.getParentTaskId());
				t.setParentTask(parentTask);
			}

			Project project = new Project();
			project.setProjectId(task.getProjectId());

			t.setProject(project);
			t.setTask(task.getTaskName());
			t.setStartDate(task.getStartDate());
			t.setEndDate(task.getEndDate());
			t.setPriority(task.getPriority());

			User user = new User();
			user.setUserId(task.getUserId());
			t.setUser(user);
			t.setStatus("STARTED");
			taskRepo.save(t);
		}

		return "Saved";
	}

	public List<TaskObj> getAllTasks() {
		List<TaskObj> taskObjList = new ArrayList<>();
		List<Task> taskList = (List<Task>) taskRepo.findAll();
		for (Task t : taskList) {
			TaskObj obj = new TaskObj();
			obj.setTaskId(t.getTaskId());
			obj.setTaskName(t.getTask());
			obj.setStartDate(t.getStartDate());
			obj.setEndDate(t.getEndDate());
			obj.setPriority(t.getPriority());
			obj.setStatus(t.getStatus());
			if (null != t.getParentTask()) {
				obj.setParentTaskId(t.getParentTask().getParentId());
				obj.setParentTaskName(t.getParentTask().getParentTask());
			}
			if (null != t.getProject()) {
				obj.setProjectName(t.getProject().getProject());
				obj.setProjectId(t.getProject().getProjectId());
			}
			if (null != t.getUser()) {
				obj.setUserName(t.getUser().getFirstName());
				obj.setUserId(t.getUser().getUserId());
			}

			taskObjList.add(obj);

		}

		return taskObjList;
	}

	public Task updateTask(TaskObj task) {
		Task t = taskRepo.findOne(task.getTaskId());

		ParentTask parentTask = new ParentTask();
		parentTask.setParentId(task.getParentTaskId());
		t.setParentTask(parentTask);

		Project project = new Project();
		project.setProjectId(task.getProjectId());
		t.setProject(project);

		t.setTask(task.getTaskName());
		t.setStartDate(task.getStartDate());
		t.setEndDate(task.getEndDate());
		t.setPriority(task.getPriority());
		t.setStatus(task.getStatus());
		return taskRepo.save(t);
	}

	public Iterable<TaskObj> getTasksByProject(Long id) {
		List<TaskObj> taskObjList = new ArrayList<>();
		List<Task> taskList = taskRepo.findAll(Arrays.asList(id.intValue()));
		for (Task t : taskList) {
			TaskObj obj = new TaskObj();
			obj.setTaskId(t.getTaskId());

			obj.setTaskName(t.getTask());
			obj.setStartDate(t.getStartDate());
			obj.setEndDate(t.getEndDate());
			obj.setPriority(t.getPriority());
			obj.setStatus(t.getStatus());

			if (null != t.getParentTask()) {
				obj.setParentTaskId(t.getParentTask().getParentId());
				obj.setParentTaskName(t.getParentTask().getParentTask());
			}
			if (null != t.getProject()) {
				obj.setProjectName(t.getProject().getProject());
				obj.setProjectId(t.getProject().getProjectId());
			}
			if (null != t.getUser()) {
				obj.setUserName(t.getUser().getFirstName());
				obj.setUserId(t.getUser().getUserId());
			}

			taskObjList.add(obj);

		}
		return taskObjList;
	}

	public Task endTask(TaskObj task) {
		Task t = taskRepo.findOne(task.getTaskId());

		t.setStatus("COMPLETED");
		return taskRepo.save(t);
	}

}
