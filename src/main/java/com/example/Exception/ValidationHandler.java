package com.example.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//this class is going to handle the exceptions which are generated in the entire application 

@RestControllerAdvice
public class ValidationHandler 
{

	/*
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public Map<String,
	 * String> handlemethod(MethodArgumentNotValidException ex){
	 * 
	 * Map<String,String> errors=new HashMap<>();
	 * ex.getBindingResult().getAllErrors().forEach((error)->{ String
	 * fieldName=((FieldError) error).getField(); String
	 * message=error.getDefaultMessage(); errors.put(fieldName, message);
	 * 
	 * }); return errors; }
	 */

@ExceptionHandler(ResourceNotFoundException.class)
public Map<String, String> handlemethod(ResourceNotFoundException ex){

	Map<String,String> errors=new HashMap<>();
	
		errors.put("errorMessage", ex.getMessage());
		
	
	return errors;
}
/*
 * @ExceptionHandler(CustomerNotFoundException.class) public Map<String, String>
 * handleCustomerMethod(CustomerNotFoundException ex){
 * 
 * Map<String,String> errors=new HashMap<>();
 * 
 * errors.put("errorMessage", ex.getMessage());
 * 
 * 
 * return errors; }
 */
}