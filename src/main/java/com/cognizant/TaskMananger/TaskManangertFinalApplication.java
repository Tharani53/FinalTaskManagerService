package com.cognizant.TaskMananger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class TaskManangertFinalApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TaskManangertFinalApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(TaskManangertFinalApplication.class);
	}
}
