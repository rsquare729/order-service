package com.order_service.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionhandler {
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String,Object> runtimeExceptionHandler(RuntimeException ex){
		Map<String,Object> error=new HashMap<String,Object>();
		error.put("Date", LocalDateTime.now());
		error.put("Message", ex.getMessage());
		return error;
	}

}
