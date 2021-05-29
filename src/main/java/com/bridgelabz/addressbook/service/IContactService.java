package com.bridgelabz.addressbook.service;

import java.util.List;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.ContactModel;
import com.bridgelabz.addressbook.util.Response;

public interface IContactService {

	Response addcontact(ContactDTO contactdto);

	Response updatecontact(String token, ContactDTO contactdto);

	List<ContactModel> getallcontact(String token);

	Response deletecontact(String token);

	List<ContactModel> getcity(String token, String city);

}
