package com.bridgelabz.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.ContactModel;
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
	
	@PutMapping("/updatecontact/{token}")
	ResponseEntity<Response> updatecontact(@PathVariable String token,@RequestBody ContactDTO contactdto){
		Response response=contactservice.updatecontact(token,contactdto);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	@GetMapping("/getallcontact/{token}")
	ResponseEntity<List<?>> getallContact(@PathVariable String token){
		
		
		List<ContactModel> response=contactservice.getallcontact(token);
		return new ResponseEntity<List<?>>(response,HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/deletecontact")
	ResponseEntity<Response> deletecontact(@RequestParam String token){
		Response response=contactservice.deletecontact(token);
		return new ResponseEntity<>(response,HttpStatus.OK);

		
	}
	
	@GetMapping("/getcity/{token}")
	ResponseEntity<List<?>> getCity(@PathVariable String token,@RequestParam String City){
		
		
		List<ContactModel> response=contactservice.getcity(token,City);
		return new ResponseEntity<List<?>>(response,HttpStatus.OK);
		 
		
	}
	
	
	

}
