package com.cognizant.TaskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.TaskManager.entity.ParentTask;

@Repository
public interface ParentTaskRepository extends JpaRepository<ParentTask, Integer> {

}
