package com.cg.POSSprint5.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
	public class PizzaExceptionHandler extends ResponseEntityExceptionHandler{
 
	@ExceptionHandler(PizzaException.class)
	public final ResponseEntity<PizzaExceptionResponse> handlePizzaErrorException(PizzaException exception, WebRequest request ){
		PizzaExceptionResponse pizzaExceptionResponse = new PizzaExceptionResponse(new Date(), exception.getMessage());
		return new ResponseEntity<>(pizzaExceptionResponse, HttpStatus.NOT_FOUND);
		
	}	
}
