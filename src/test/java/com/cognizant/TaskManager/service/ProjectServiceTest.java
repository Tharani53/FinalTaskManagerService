package com.cognizant.TaskManager.service;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.TaskManager.entity.Project;
import com.cognizant.TaskManager.entity.Task;
import com.cognizant.TaskManager.entity.User;
import com.cognizant.TaskManager.model.ProjectObj;
import com.cognizant.TaskManager.repository.ProjectRepository;
import com.cognizant.TaskManager.service.ProjectService;

public class ProjectServiceTest {
	@InjectMocks
	ProjectService service;

	@Mock
	ProjectRepository repo;

	@Before
	public void setUp() {
		initMocks(this);
	}
	@Test
	public void addProjectTest()
			throws ParseException {/*
									 * Project project = new Project(); project.setProject(p.getProjectName());
									 * project.setStartDate(p.getStartDate()); project.setEndDate(p.getEndDate());
									 * project.setPriority(p.getPriority()); project.setUserId(p.getUserId());
									 * projectRepository.save(project); p.setCompletedTaskNumber(0);
									 * p.setTaskNumber(0); return p;
									 */
		// Integer projectId, String project, Date startDate, Date endDate, Integer
		// priority, Integer userId

		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String startDate = "15-10-2015";
		Date dateOne = sdf.parse(startDate);

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");
		String endDate = "15-10-2015";
		Date dateTwo = sdf.parse(startDate);

		Project project = new Project(1L, "project", dateOne, dateTwo, 1);

		ProjectObj p = new ProjectObj();

		service.addProject(p);

		// ((ProjectService) verify(repo, times(0))).addProject(p);
	}

	@Test

	public void updateProject() throws ParseException {

		ProjectObj p = new ProjectObj();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String startDate = "15-10-2015";
		Date dateOne = sdf.parse(startDate);
		p.setProjectId(123L);

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");
		String endDate = "15-10-2015";
		Date dateTwo = sdf.parse(startDate);

		Project project = new Project(1L, "project", dateOne, dateTwo, 1);
		Project project2 = new Project(1L, "project12", dateOne, dateTwo, 23);
		when(repo.findOne(123L)).thenReturn(project2);
		when(service.updateProject(p)).thenReturn(p);

		project2.setProject(project.getProject());
		project2.setStartDate(project.getStartDate());
		project2.setEndDate(project.getEndDate());
		project2.setPriority(project.getPriority());
		repo.save(project2);
	}
	@Test
	
	public void updateProject1() throws ParseException {
		
		ProjectObj p = new ProjectObj();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String startDate = "15-10-2015";
		Date dateOne = sdf.parse(startDate);
		p.setProjectId(123L);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");
		String endDate = "15-10-2015";
		Date dateTwo = sdf.parse(startDate);
		
		Project project = new Project(1L, "project", dateOne, dateTwo, 1);
		Project project2 = new Project(1L, "project12", dateOne, dateTwo, 23);
		when(repo.findOne(123L)).thenReturn(null);
		when(service.updateProject(p)).thenReturn(p);
		
		project2.setProject(project.getProject());
		project2.setStartDate(project.getStartDate());
		project2.setEndDate(project.getEndDate());
		project2.setPriority(project.getPriority());
		repo.save(project2);
	}

	@Test
	public void getAllProject() {

		List<Project> projectList = new ArrayList<>(
				Arrays.asList(new Project(1L, "Sample", new Date(), new Date(), 20)));
		projectList.get(0).setTasks(Arrays.asList(new Task()));
		projectList.get(0).setUser(new User());
		List<ProjectObj> projectResponseList = new ArrayList<>();
		when(repo.findAll()).thenReturn(projectList);
		when(service.getAllProject()).thenReturn(projectResponseList);

		projectList = repo.findAll();

	}

	@Test

	public void setAndGetProjectId() {
		Project p = new Project();
		p.setProjectId(1L);
		p.getProjectId();
	}

}
