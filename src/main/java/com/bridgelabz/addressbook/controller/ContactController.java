package com.bridgelabz.addressbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.service.IContactService;
import com.bridgelabz.addressbook.util.Response;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	IContactService contactservice;
	
	
	@PostMapping("/addnewcontact")
	ResponseEntity<Response> createcontact(@RequestBody ContactDTO contactdto){
		
		Response response=contactservice.addcontact(contactdto);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}

}
