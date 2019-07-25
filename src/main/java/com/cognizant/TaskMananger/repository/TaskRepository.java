package com.cognizant.TaskMananger.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.TaskMananger.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
