package com.careerit.jfs.cj.jdbc.assignment;

import java.util.List;
import java.util.Optional;

public class ContactServiceImpl implements ContactService {

    private final ContactDao contactDao;

    public ContactServiceImpl(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public Contact createContact(Contact contact) {
        Optional<Contact> contactOptional = contactDao.findByMobile(contact.getMobile());
        if (contactOptional.isPresent()) {
            throw new RuntimeException("Contact already exists with mobile: " + contact.getMobile());
        }
        Contact savedContact = contactDao.create(contact);
        System.out.println("Contact created successfully with id: " + savedContact.getId());
        return savedContact;
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return contactDao.findById(id);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactDao.findAll();
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactDao.update(contact);
    }

    @Override
    public boolean deleteContact(Long id) {
        return contactDao.delete(id);
    }

    @Override
    public List<Contact> searchContactsByName(String name) {
        return contactDao.searchByName(name);
    }
}
