package com.example.todolistapi.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.todolistapi.constant.Constants;
import com.example.todolistapi.exception.IdNotFoundException;
import com.example.todolistapi.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundException(IdNotFoundException exception){
		ResponseStructure<String> responseStructureException = new ResponseStructure<String>();
		responseStructureException.setData(exception.getMessage());
		responseStructureException.setMessage(Constants.STATUS_NOT_FOUND_MSG);
		responseStructureException.setStatusCode(Constants.STATUS_CODE_NOT_FOUND);
		return new ResponseEntity<ResponseStructure<String>>(responseStructureException,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> resourceNotFoundException(ResourceNotFoundException exception){
		ResponseStructure<String> responseStructureException = new ResponseStructure<String>();
		responseStructureException.setData(exception.getMessage());
		responseStructureException.setMessage(Constants.STATUS_NOT_FOUND_MSG);
		responseStructureException.setStatusCode(Constants.STATUS_CODE_NOT_FOUND);
		return new ResponseEntity<ResponseStructure<String>>(responseStructureException,HttpStatus.NOT_FOUND);
		
	}
	
	
}
