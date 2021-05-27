package com.bridgelabz.addressbook.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;

@ResponseStatus
@Data
public class ContactRegisterException extends RuntimeException {

	public ContactRegisterException(int statusCode, String statusmessage) {
		super();
		StatusCode = statusCode;
		Statusmessage = statusmessage;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int StatusCode;
	private String Statusmessage;
	

}
