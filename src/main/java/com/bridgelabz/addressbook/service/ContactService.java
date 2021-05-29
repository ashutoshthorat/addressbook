package com.bridgelabz.addressbook.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.exception.ContactRegisterException;
import com.bridgelabz.addressbook.model.ContactModel;
import com.bridgelabz.addressbook.repository.ContactRepository;
import com.bridgelabz.addressbook.util.Response;
import com.bridgelabz.addressbook.util.TokenUtil;

@Service
public class ContactService implements IContactService {
	@Autowired
	ContactRepository contactrepository;
	
	@Autowired
	ModelMapper modelmapper;
	@Autowired
	TokenUtil tokenutil;

	@Override
	public Response addcontact(ContactDTO contactdto) {
		Optional<ContactModel> isPresent=contactrepository.findByEmailid(contactdto.getEmailid());
		if(isPresent.isPresent()) {
			throw new ContactRegisterException(400, "Contact Already Added");
		}else {
			ContactModel contact=modelmapper.map(contactdto, ContactModel.class);
			contactrepository.save(contact);
			String token=tokenutil.createToken(contact.getId());
			return new Response(200, "Contact Succefully Added", token);
		}
		
	}

	@Override
	public Response updatecontact(String token, ContactDTO contactdto) {
		Long id=tokenutil.decodeToken(token);
		Optional<ContactModel> isContactPresent=contactrepository.findById(id);
		if(isContactPresent.isPresent()) {
			System.out.println(isContactPresent.get());
			isContactPresent.get().setFirstname(contactdto.getFirstname());
			isContactPresent.get().setAddress(contactdto.getAddress());
			isContactPresent.get().setLastname(contactdto.getLastname());
			isContactPresent.get().setEmailid(contactdto.getEmailid());
			isContactPresent.get().setUpdatedDate(LocalDateTime.now());
			isContactPresent.get().setMobileNo(contactdto.getMobileNo());
			contactrepository.save(isContactPresent.get());
			return new Response(200, "Contact Succefully Updated", null);
			
		}else {
			throw new ContactRegisterException(400, "Contact is not saved!!");
		}
	
	}

	@Override
	public List<ContactModel> getallcontact(String token) {
		Long id=tokenutil.decodeToken(token);
		Optional<ContactModel> isContactPresent=contactrepository.findById(id);
		if(isContactPresent.isPresent()) {
			List<ContactModel> getallcontacts=contactrepository.findAll();
			return getallcontacts;
		}else {
			throw new ContactRegisterException(400, "Token is not valid!!");
		}
		
	}

	@Override
	public Response deletecontact(String token) {
		Long id=tokenutil.decodeToken(token);
		Optional<ContactModel> isContactPresent=contactrepository.findById(id);
		if(isContactPresent.isPresent()) {
			contactrepository.delete(isContactPresent.get());
			return new Response(200, "Contact Succefully deleted", null);
			
			
		}else {
			throw new ContactRegisterException(400, "Contact is not preset!!");
		}
	}

	@Override
	public List<ContactModel> getcity(String token, String city) {
		Long id=tokenutil.decodeToken(token);
		Optional<ContactModel> isContactPresent=contactrepository.findById(id);
		if(isContactPresent.isPresent()) {
			List<ContactModel> getcontactsbycity=contactrepository.findByCityStartsWith(city);
			
			return getcontactsbycity;
			
			
		}else {
			throw new ContactRegisterException(400, "Contact is not preset!!");
		}
	}
	
	

}
