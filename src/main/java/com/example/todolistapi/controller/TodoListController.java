package com.example.todolistapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolistapi.dto.ResponseStructure;
import com.example.todolistapi.entity.Task;
import com.example.todolistapi.service.TodoListService;

@RestController
@RequestMapping("/todolist")
public class TodoListController {
	
	@Autowired
	private TodoListService todoListService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Task>> saveTask(@RequestBody Task task){
		 return todoListService.saveTask(task);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Task>>> getAllTask(){
		return todoListService.getAllTask();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Task>> deleteTaskById(@PathVariable int id){
		return todoListService.deleteTaskById(id);
	}
}
