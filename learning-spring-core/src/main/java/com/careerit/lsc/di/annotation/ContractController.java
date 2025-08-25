package com.careerit.lsc.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ContractController {

    @Autowired
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
