package com.cognizant.TaskManager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.TaskManager.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}