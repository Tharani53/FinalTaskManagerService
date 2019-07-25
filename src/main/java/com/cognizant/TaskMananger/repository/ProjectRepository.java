package com.cognizant.TaskMananger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.TaskMananger.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
