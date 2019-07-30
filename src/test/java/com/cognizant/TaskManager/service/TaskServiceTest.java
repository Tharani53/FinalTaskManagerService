package com.cognizant.TaskManager.service;

import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.TaskManager.entity.ParentTask;
import com.cognizant.TaskManager.entity.Project;
import com.cognizant.TaskManager.entity.Task;
import com.cognizant.TaskManager.entity.User;
import com.cognizant.TaskManager.model.TaskObj;
import com.cognizant.TaskManager.repository.TaskRepository;
import com.cognizant.TaskManager.service.TaskService;

public class TaskServiceTest {

	@InjectMocks
	private TaskService taskService;

	@Mock
	private TaskRepository taskRepo;

	@Before
	public void setUp() {
		initMocks(this);
	}

	@After
	public void validate() {
		validateMockitoUsage();
	}

	@Test
	public void updateTaskTest() throws ParseException {

		Task t = new Task();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String startDate = "15-10-2015";
		Date dateOne = sdf.parse(startDate);

		Date dateTwo = sdf.parse(startDate);
		Task temp = new Task(1, dateOne, dateTwo, 1, "STARTED");

		when(taskRepo.findOne(123)).thenReturn(temp);
		t.setTask(temp.getTask());
		t.setStartDate(temp.getStartDate());
		t.setEndDate(temp.getEndDate());
		t.setPriority(temp.getPriority());
		t.setStatus(temp.getStatus());
		taskRepo.save(t);
	}

	@Test
	public void getTasksByProjectTest() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String startDate = "15-10-2015";
		Date dateOne = sdf.parse(startDate);

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");
		String endDate = "15-10-2015";
		Date dateTwo = sdf.parse(startDate);

		List<Task> taskList = new ArrayList<>();
		when(taskRepo.findAll()).thenReturn(taskList);

	}

	@Test
	public void addNewTaskTest() throws ParseException

	{

		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String startDate = "15-10-2015";
		Date dateOne = sdf.parse(startDate);

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");
		Date dateTwo = sdf.parse(startDate);

		TaskObj task = new TaskObj();

		Task t = new Task(12, dateOne, dateTwo, 1, "STARTED");
		taskService.addNewTask(task);

	}

	@Test
	public void addNewTaskTest2() {

		ParentTask pTask = new ParentTask();
		pTask.setParentTask("task");
		TaskObj task = new TaskObj();
		taskService.addNewTask(task);

	}

	@Test

	public void getAllTasksTest() throws ParseException {
		List<TaskObj> taskObjList = new ArrayList<>();
		List<Task> taskList = new ArrayList<>(Arrays.asList(new Task()));
		taskList.get(0).setUser(new User());
		taskList.get(0).setProject(new Project());
		when(taskRepo.findAll()).thenReturn(taskList);
		when(taskService.getAllTasks()).thenReturn(taskObjList);
	}
}
