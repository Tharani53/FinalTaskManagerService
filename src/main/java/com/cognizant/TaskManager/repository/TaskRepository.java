package com.cognizant.TaskManager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.TaskManager.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
