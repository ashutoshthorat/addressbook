package com.bridgelabz.addressbook.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class ContactDTO {
	
	@NotNull(message = "first name cannot be Null")
	private String firstname;
	@NotNull(message = "last name cannot be Null")
	private String lastname;
	@NotNull(message = "mobile no cannot be Null")
	private String mobileNo;
	@NotNull
	private String emailid;
	@NotNull
	private String address;

}
