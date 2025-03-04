package com.example.todolistapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.todolistapi.entity.Task;
import com.example.todolistapi.repository.TodoListRepository;

import jakarta.annotation.Resource;

@Repository
public class TodoListDao {
	
	@Autowired
	private TodoListRepository todoListRepository;

	public Task saveTask(Task task) {
		return todoListRepository.save(task);
	}

	public List<Task> getAllTask() {
		return todoListRepository.findAll();
	}
	
	public Optional<Task> findTaskById(int id) {
		return todoListRepository.findById(id);
	}

	public void deleteTaskById(int id) {
		todoListRepository.deleteById(id);
	}

}
