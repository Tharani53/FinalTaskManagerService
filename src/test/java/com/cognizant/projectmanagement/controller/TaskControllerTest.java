package com.cognizant.projectmanagement.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.TaskManager.controller.TaskController;
import com.cognizant.TaskManager.entity.Project;
import com.cognizant.TaskManager.entity.Task;
import com.cognizant.TaskManager.entity.User;
import com.cognizant.TaskManager.model.TaskObj;
import com.cognizant.TaskManager.service.TaskService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TaskController.class, secure = false)
public class TaskControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TaskService taskService;

	final Date date = Mockito.mock(Date.class);

	@Test
	public void testGetAllTasks() throws Exception {

		TaskObj mockTask = new TaskObj();
		mockTask.setParentTaskId(1);
		mockTask.setProjectId(1L);
		mockTask.setTaskName("A");
		mockTask.setStartDate(date);
		mockTask.setEndDate(date);
		mockTask.setPriority(1);
		mockTask.setUserId(1);

		List<TaskObj> ticketList = new ArrayList<TaskObj>();
		ticketList.add(mockTask);

		Mockito.when(taskService.getAllTasks()).thenReturn(ticketList);

		String URI = "/task/all";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(ticketList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	@Test
	public void addNewTaskTest() throws Exception {

		TaskObj mockTask = new TaskObj();
		TaskObj task = new TaskObj();
		mockTask.setParentTaskId(1);
		mockTask.setProjectId(1L);
		mockTask.setTaskName("A");
		mockTask.setStartDate(date);
		mockTask.setEndDate(date);
		mockTask.setPriority(1);
		mockTask.setUserId(1);

		// ParentTask ptask = new ParentTask();
		// String task="taskName";
		// ptask.setParentTask(task);

		String inputInJson = this.mapToJson(mockTask);

		String URI = "/task/add";

		// Mockito.when(taskService.addNewTask(task)).thenReturn(mockTask);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(inputInJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String outputInJson = response.getContentAsString();
	}

	@Test
	public void getTasksByProjectTest() throws Exception {
		TaskObj mockTask = new TaskObj();
		mockTask.setParentTaskId(1);
		mockTask.setProjectId(1L);
		mockTask.setTaskName("A");
		mockTask.setStartDate(date);
		mockTask.setEndDate(date);
		mockTask.setPriority(1);
		mockTask.setUserId(1);

		List<TaskObj> ticketList = new ArrayList<TaskObj>();
		ticketList.add(mockTask);

		Mockito.when(taskService.getTasksByProject(1L)).thenReturn(ticketList);

		String URI = "/task/project/{id}";
		/*
		 * RequestBuilder requestBuilder = MockMvcRequestBuilders.get( URI).accept(
		 * MediaType.APPLICATION_JSON);
		 * 
		 * MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 * 
		 * String expectedJson = this.mapToJson(ticketList); String outputInJson =
		 * result.getResponse().getContentAsString();
		 * assertThat(outputInJson).isEqualTo(expectedJson);
		 */
	}

	@Test
	public void updateTaskTest() throws Exception {

		Task mockTask = new Task();
		TaskObj obj = new TaskObj();

		mockTask.setTaskId(1);

		Project project = new Project();
		project.setProjectId(1L);
		mockTask.setProject(project);
		mockTask.setTask("A");
		mockTask.setStartDate(date);
		mockTask.setEndDate(date);
		mockTask.setPriority(1);

		User user = new User();
		user.setUserId(1);
		mockTask.setUser(user);

		Mockito.when(taskService.updateTask(obj)).thenReturn(mockTask);

		String URI = "/task/update";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(mockTask);
		String outputInJson = result.getResponse().getContentAsString();
		// assertThat(outputInJson).isEqualTo(expectedJson);
	}

}
