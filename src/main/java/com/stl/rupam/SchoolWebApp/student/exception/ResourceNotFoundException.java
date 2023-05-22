package com.stl.rupam.SchoolWebApp.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
//	String resourceName;
//	String fieldName;
//	String fieldValue;
//	
//	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue)
//	{
//		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
//		this.resourceName = resourceName;
//		this.fieldName = fieldName;
//		this.fieldValue = fieldValue;
//	}
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
	

}
