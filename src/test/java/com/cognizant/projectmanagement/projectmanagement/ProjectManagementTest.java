package com.cognizant.projectmanagement.projectmanagement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.TaskMananger.TaskManangertFinalApplication;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectManagementTest {

	@Test
	public void contextLoads() {
	}

	
	@Test
	   public void main() {
		TaskManangertFinalApplication.main(new String[] {});
	   }
	
	@Test
	public void configueTest() {
		SpringApplicationBuilder builder = new SpringApplicationBuilder();
			
			 builder.sources(TaskManangertFinalApplication.class);	
		//ProjectMangementFinalApplication.configure(builder);
	}
	
}