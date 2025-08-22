package com.careerit.cbook.service;

import com.careerit.cbook.dto.ContactDto;
import com.careerit.cbook.records.ContactCount;

import java.util.List;
import java.util.UUID;

public interface ContactService {
    ContactDto create(ContactDto contactDto);
    List<ContactDto> getContacts();
    void delete(UUID id);
    ContactDto update(ContactDto contactDto);
    List<ContactDto> searchContactsByName(String name);
    ContactDto getContactById(UUID id);
    ContactCount getCount();
}
