package com.efitel.inventory.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

//import com.efitel.inventory.services.inventoryItem.impl.EntityNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> handleBusinessException(BusinessException ex, HttpServletRequest request){
		Map<String, Object> response = new HashMap<>();
		response.put("error", ex.getMessage());
		response.put("status", HttpStatus.BAD_REQUEST.value());
		response.put("timestamp", LocalDateTime.now().toString());
		response.put("path", request.getRequestURL().toString());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request){	
		//Iterate over each error and extract messages
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			String fieldName = error.getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		// build answer
		Map<String, Object> response = new HashMap<>();
		response.put("error", errors);
		response.put("status", HttpStatus.BAD_REQUEST.value());
		response.put("timestamp", LocalDateTime.now().toString());
		response.put("path", request.getRequestURL().toString());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public  ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException ex, HttpServletRequest request){
		Map<String, Object> response =new HashMap<>();
		response.put("error", "Not found");
		response.put("status", HttpStatus.NOT_FOUND.value());
		response.put("message", ex.getMessage());
		response.put("timestamp", LocalDateTime.now().toString());
		response.put("path", request.getRequestURL().toString());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		
	}
}
