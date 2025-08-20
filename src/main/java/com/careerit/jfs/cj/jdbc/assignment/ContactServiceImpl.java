package com.careerit.jfs.cj.jdbc.assignment;

import java.util.List;
import java.util.Optional;

public class ContactServiceImpl implements ContactService {

    private ContactDao contactDao;

    public ContactServiceImpl(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public Contact createContact(Contact contact) {
        // Validation logic
        Optional<Contact> contactOptional = contactDao.findByMobile(contact.getMobile());
        if (contactOptional.isPresent()) {
            throw new RuntimeException("Contact already exists");
        }
        Contact savedContact = contactDao.create(contact);
        System.out.println("Contact is created successfully with id: " + savedContact.getId());
        return savedContact;
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Contact> getAllContacts() {
        return List.of();
    }

    @Override
    public Contact updateContact(Contact contact) {
        return null;
    }

    @Override
    public boolean deleteContact(Long id) {
        return false;
    }

    @Override
    public List<Contact> searchContactsByName(String name) {
        return List.of();
    }
}
