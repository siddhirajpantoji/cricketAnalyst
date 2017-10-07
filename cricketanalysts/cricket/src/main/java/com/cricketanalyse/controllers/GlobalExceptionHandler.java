package com.cricketanalyse.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cricketanalyse.response.BaseResponse;
import com.cricketanalyse.response.ValidationResponse;
import com.cricketanalyse.util.Messages;


@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	private Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
	@ExceptionHandler( value = Exception.class)
	public ResponseEntity<BaseResponse> handleAllException ( Exception exception)
	{
		logger.error("Exception OCcured ", exception);
		return new ResponseEntity<BaseResponse>(new BaseResponse(HttpStatus.INTERNAL_SERVER_ERROR, Messages.SOMETHING_WENT_WRONG), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler ( value = HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<BaseResponse> handleMethodNotSupportedException ( HttpRequestMethodNotSupportedException exception)
	{
		logger.error("HttpRequestMethodNotSupportedException OCcured ", exception);
		return new ResponseEntity<BaseResponse>(new BaseResponse(HttpStatus.METHOD_NOT_ALLOWED, Messages.METHOD_NOT_SUPPORTED), HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler ( value = MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationResponse> handleMethodNotValidException ( MethodArgumentNotValidException exception)
	{
		logger.error("MethodArgumentNotValidException OCcured ", exception);
		Map<String,String> errorMap = null;
		BindingResult bindingResult = exception.getBindingResult();
		if(! CollectionUtils.isEmpty(bindingResult.getAllErrors()))
		{
			errorMap= new HashMap<>();
			for (Object object : bindingResult.getAllErrors()) {
				if(object instanceof FieldError) {
					FieldError fieldError = (FieldError) object;
					errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
				}
			}
			if( errorMap.size() >0)
			{
				return new ResponseEntity<ValidationResponse>(new ValidationResponse(HttpStatus.BAD_REQUEST, Messages.INVALID_REQUEST, errorMap), HttpStatus.BAD_REQUEST);		
			}
		}
		return new ResponseEntity<ValidationResponse>(new ValidationResponse(HttpStatus.BAD_REQUEST, Messages.INVALID_REQUEST), HttpStatus.BAD_REQUEST);
	}

	//HttpMessageNotReadableException
	@ExceptionHandler ( value = HttpMessageNotReadableException.class)
	public ResponseEntity<BaseResponse> handleHttpMessageNotReadableException ( HttpMessageNotReadableException exception)
	{
		logger.error("HttpMessageNotReadableException OCcured ", exception);
		return new ResponseEntity<BaseResponse>(new BaseResponse(HttpStatus.BAD_REQUEST, Messages.INVALID_REQUEST), HttpStatus.BAD_REQUEST);
	}
	//MissingPathVariableException
	
	@ExceptionHandler( value = MissingPathVariableException.class )
	public ResponseEntity<BaseResponse> handleException ( MissingPathVariableException exception)
	{
		logger.error("MissingPathVariableException OCcured ", exception);
		return new ResponseEntity<BaseResponse>(new BaseResponse(HttpStatus.BAD_REQUEST, Messages.INVALID_REQUEST), HttpStatus.BAD_REQUEST);
	}
	// ConstraintViolationException

	/*@ExceptionHandler ( value = ConstraintViolationException.class)
	public ResponseEntity<BaseResponse> handleHttpMessageNotReadableException ( ConstraintViolationException exception)
	{
		logger.error("ConstraintViolationException OCcured ", exception);
		StringBuilder sb = new StringBuilder();
		for (ConstraintViolation<?> violation : exception.getConstraintViolations())
		{
			sb.append("Error: " + violation.getPropertyPath() + " : " + violation.getMessage() + "\n");
		}
		return new ResponseEntity<BaseResponse>(new BaseResponse(HttpStatus.BAD_REQUEST, sb.toString()), HttpStatus.BAD_REQUEST);
	}*/

}
