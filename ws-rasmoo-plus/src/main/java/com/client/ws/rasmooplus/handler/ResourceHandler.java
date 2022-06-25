package com.client.ws.rasmooplus.handler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.client.ws.rasmooplus.dto.error.ErrorResponseDto;
import com.client.ws.rasmooplus.dto.error.FieldsErrors;
import com.client.ws.rasmooplus.exception.BadRequestException;
import com.client.ws.rasmooplus.exception.NotFoundException;

@RestControllerAdvice
public class ResourceHandler {
	
	@Autowired
	private MessageSource messageSource;	
	
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponseDto> notFoundException(NotFoundException exception)
	{
		ErrorResponseDto dto = new ErrorResponseDto();
		
		dto.setDate_error(LocalDateTime.now());
		dto.setTitulo(exception.getMessage());
		dto.setStatus(HttpStatus.NOT_FOUND);
		dto.setStatusCode(HttpStatus.NOT_FOUND.value());		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
	}
	
	
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<String> badRequestException(BadRequestException exception)
	{
		String errorMessage = exception.getMessage();
		
		return ResponseEntity.badRequest().body(errorMessage);
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDto> methodArgumentNotValidException(MethodArgumentNotValidException exception)
	{
		
		List<FieldsErrors> errorsDto = new ArrayList<>();
		
		for (ObjectError error : exception.getBindingResult().getAllErrors()) {
			
			String field = ((FieldError)error) .getField();
			String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			
			errorsDto.add(new FieldsErrors(field, message));
			
		}
		
		
		
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
