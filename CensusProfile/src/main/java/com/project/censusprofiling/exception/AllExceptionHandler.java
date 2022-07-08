package com.project.censusprofiling.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllExceptionHandler {

	@ExceptionHandler({ UserInvalidCredentialsException.class, MemberInvalidCredentialsException.class,
			AddressInvalidCredentialsException.class, ApplicationInvalidCredentialsException.class, })
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	@ExceptionHandler({ UserNotFoundException.class, UserAlreadyExistsException.class, MemberNotFoundException.class,
			MemberAlreadyExistsException.class, AddressNotFoundException.class, AddressAlreadyExistsException.class,
			ApplicationNotFoundException.class, ApplicationAlreadyExistsException.class, Exception.class })
	public Map<String, String> handleAddressNotFoundException(Exception ex) {
		System.out.println("i am here");
		Map<String, String> errors = new HashMap<>();
		errors.put("Error", ex.toString());
		errors.put("Message", ex.getMessage());
		return errors;
	}

}
