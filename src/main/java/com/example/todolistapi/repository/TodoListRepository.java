package com.example.todolistapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolistapi.entity.Task;

public interface TodoListRepository extends JpaRepository<Task, Integer>{

}
