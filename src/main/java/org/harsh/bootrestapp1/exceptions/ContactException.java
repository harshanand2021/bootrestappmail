package org.harsh.bootrestapp1.exceptions;

public class ContactException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ContactException() {

	}

	public ContactException(String message) {
		super(message);
	}

	public ContactException(Throwable cause) {
		super(cause);
	}

	public ContactException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ContactException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
