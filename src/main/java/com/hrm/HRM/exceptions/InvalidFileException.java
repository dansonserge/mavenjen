package com.hrm.HRM.exceptions;

public class InvalidFileException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidFileException(String msg){
		super(msg);
	}
}
