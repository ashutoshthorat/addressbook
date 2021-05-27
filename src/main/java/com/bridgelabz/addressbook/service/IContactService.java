package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.util.Response;

public interface IContactService {

	Response addcontact(ContactDTO contactdto);

}
