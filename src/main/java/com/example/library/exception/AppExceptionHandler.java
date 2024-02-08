package com.example.library.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class AppExceptionHandler { // TransactionSystemException

	 @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(ConstraintViolationException.class)
	    public Map<String, String> handleInvalidArgument(ConstraintViolationException ex) {
	        Map<String, String> errorMap = new HashMap<>();
	        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
	            String propertyPath = violation.getPropertyPath().toString();
	            String message = violation.getMessage();

	            String field = propertyPath.substring(propertyPath.lastIndexOf('.') + 1);
	            
	            errorMap.put(field, message);
	        }

	        return errorMap;
	    }
	 
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    @ExceptionHandler(AuthorNotFoundException.class)
	    public Map<String, String> handleBusinessException(AuthorNotFoundException ex) {
	        Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", ex.getMessage());
	        return errorMap;
	    }
	    
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    @ExceptionHandler(BookNotFoundException.class)
	    public Map<String, String> handleBusinessException(BookNotFoundException ex) {
	        Map<String, String> errorMap = new HashMap<>();
	        errorMap.put("errorMessage", ex.getMessage());
	        return errorMap;
	    }

}
