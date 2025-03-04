package com.example.todolistapi.service;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.todolistapi.constant.Constants;
import com.example.todolistapi.dao.TodoListDao;
import com.example.todolistapi.dto.ResponseStructure;
import com.example.todolistapi.entity.Task;
import com.example.todolistapi.exception.IdNotFoundException;
import com.example.todolistapi.exception.ResourceNotFoundException;

@Service
public class TodoListService {

	@Autowired
	private TodoListDao todoListDao;

	public ResponseEntity<ResponseStructure<Task>> saveTask(Task task) {
		Task taskDb = todoListDao.saveTask(task);
		ResponseStructure<Task> taskResponseStructure = new ResponseStructure<Task>();
		taskResponseStructure.setMessage(Constants.STATUS_SUCCESS_MSG);
		taskResponseStructure.setData(taskDb);
		taskResponseStructure.setStatusCode(HttpStatus.OK.value());
		
		return new ResponseEntity<ResponseStructure<Task>>(taskResponseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<Task>>> getAllTask() {
		List<Task> taskList = todoListDao.getAllTask();
		if(taskList.size() > 0) {
			
		ResponseStructure<List<Task>> taskResponseStructure = new ResponseStructure<List<Task>>();
		taskResponseStructure.setData(taskList);
		taskResponseStructure.setMessage(Constants.STATUS_SUCCESS_MSG);
		taskResponseStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Task>>>(taskResponseStructure,HttpStatus.OK);
		}
		else {
			throw new ResourceNotFoundException("Task is empty try to add Something..!");
		}
		
	}

	public ResponseEntity<ResponseStructure<Task>> deleteTaskById(int id) {
		Optional<Task> optionalDeletedTask = todoListDao.findTaskById(id);
		
		if(optionalDeletedTask.isPresent()){
			ResponseStructure<Task> responseStructureTask = new ResponseStructure<Task>();
			responseStructureTask.setData(optionalDeletedTask.get());
			responseStructureTask.setMessage(Constants.STATUS_SUCCESS_MSG);
			responseStructureTask.setStatusCode(Constants.STATUS_CODE_OK);
			todoListDao.deleteTaskById(id);
			return new ResponseEntity<ResponseStructure<Task>>(responseStructureTask,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Id isn't available in DB");
		}
	}
}
