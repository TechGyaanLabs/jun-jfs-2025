package com.careerit.jfs.cj.jdbc.assignment;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    
    Contact createContact(Contact contact);
    
    Optional<Contact> getContactById(Long id);
    
    List<Contact> getAllContacts();
    
    Contact updateContact(Contact contact);
    
    boolean deleteContact(Long id);
    
    List<Contact> searchContactsByName(String name);
}
