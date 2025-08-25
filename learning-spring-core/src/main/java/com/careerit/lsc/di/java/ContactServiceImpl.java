package com.careerit.lsc.di.java;

public class ContactServiceImpl implements ContactService {

    private ContactDao contactDao;

    @Override
    public long totalActiveContacts() {
        return contactDao.getTotalContacts();
    }

    public ContactDao getContactDao() {
        return contactDao;
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }
}
