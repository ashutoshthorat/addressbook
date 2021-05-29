package com.bridgelabz.addressbook.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.addressbook.model.ContactModel;

public interface ContactRepository extends JpaRepository<ContactModel, Long> {
	
  public Optional<ContactModel> findByEmailid(String emailid);
  public List<ContactModel> findByCityStartsWith(String city);
}
