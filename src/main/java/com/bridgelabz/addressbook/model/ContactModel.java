package com.bridgelabz.addressbook.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;

import javax.persistence.Id;

@Entity
@Table(name="contact")
@Data
public class ContactModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String firstname;
	private String lastname;
	private String mobileNo;
	private LocalDateTime registeredDate=LocalDateTime.now();
	private LocalDateTime updatedDate;
	private String emailid;
	private String address;
	
	public ContactModel(Long id, String firstname, String lastname, String mobileNo, LocalDateTime registeredDate,
			LocalDateTime updatedDate, String emailid, String address) {
		super();
		Id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileNo = mobileNo;
		this.registeredDate = registeredDate;
		this.updatedDate = updatedDate;
		this.emailid = emailid;
		this.address = address;
	}
	public ContactModel()
	{
		
	}
	

}
