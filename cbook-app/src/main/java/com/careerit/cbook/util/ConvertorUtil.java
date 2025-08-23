package com.careerit.cbook.util;

import com.careerit.cbook.domin.Contact;
import com.careerit.cbook.dto.ContactDto;

public class ConvertorUtil {


    public static ContactDto toContactDto(Contact contact) {
         ContactDto contactDto = new ContactDto();
         contactDto.setId(contact.getId());
         contactDto.setName(contact.getName());
         contactDto.setEmail(contact.getEmail());
         contactDto.setMobile(contact.getMobile());
         contactDto.setDeleted(contact.isDeleted());
         return contactDto;
    }

    public static Contact toContactDomain(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setId(contactDto.getId());
        contact.setName(contactDto.getName());
        contact.setEmail(contactDto.getEmail());
        contact.setMobile(contactDto.getMobile());
        contact.setDeleted(contactDto.isDeleted());
        return contact;
    }

}
