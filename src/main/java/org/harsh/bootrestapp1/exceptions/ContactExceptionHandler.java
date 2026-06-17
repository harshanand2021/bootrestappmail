package org.harsh.bootrestapp1.exceptions;

import org.harsh.bootrestapp1.services.MailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ContactExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	MailerService mailService;

	@ExceptionHandler({ContactException.class})
	public ResponseEntity<Object> handleNoSuchContact(Exception e, WebRequest wr)
	{
		return null;
		
	}
}
