package com.agriyo.services.agriyodb.agriyodbservice.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.agriyo.services.agriyodb.agriyodbservice.exception.AgriyoBusinessException;
import com.agriyo.services.agriyodb.agriyodbservice.model.BaseBO;

/**
 * Handles requests for the application home page.
 */
@ControllerAdvice
public class BaseResource extends ResponseEntityExceptionHandler{
	
	private static final Logger logger = LoggerFactory.getLogger(BaseResource.class);
	
	@ExceptionHandler(AgriyoBusinessException.class)
	public  @ResponseBody ResponseEntity handleEmployeeNotFoundException(WebRequest request, Exception ex){
		//logger.error("Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);
		ex.printStackTrace();
		BaseBO bo= new BaseBO();
		bo.setError(ex.getMessage());
	  return  handleExceptionInternal(ex, bo, null, HttpStatus.BAD_REQUEST, request);
	    //return bo;
	}	
	
	
	@ExceptionHandler(Exception.class)
	public  @ResponseBody ResponseEntity handleGenericException(WebRequest request, Exception ex){
		//logger.error("Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);
		ex.printStackTrace();
		BaseBO bo= new BaseBO();
		bo.setError("Server error. Please try after sometime.");
		  return  handleExceptionInternal(ex, bo, null, HttpStatus.BAD_REQUEST, request);
			
	}	
}
