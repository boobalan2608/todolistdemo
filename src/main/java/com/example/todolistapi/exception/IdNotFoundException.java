package com.example.todolistapi.exception;

public class IdNotFoundException extends RuntimeException{

	public IdNotFoundException() {
	}
	public IdNotFoundException(String msg) {
		super(msg);
	}

	
}
