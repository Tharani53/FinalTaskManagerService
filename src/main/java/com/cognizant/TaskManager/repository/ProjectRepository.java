package com.cognizant.TaskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.TaskManager.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
