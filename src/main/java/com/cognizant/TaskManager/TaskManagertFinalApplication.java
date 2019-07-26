package com.cognizant.TaskManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class TaskManagertFinalApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TaskManagertFinalApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(TaskManagertFinalApplication.class);
	}
}
