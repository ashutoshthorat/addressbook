package com.bridgelabz.addressbook.service;

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

}
