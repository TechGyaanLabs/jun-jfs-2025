package com.careerit.lsc.di.java;

public class ContractController {

    private ContactService contactService;

    public long getActivateContacts() {
        return contactService.totalActiveContacts();
    }

    public ContactService getContactService() {
        return contactService;
    }

    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }
}
