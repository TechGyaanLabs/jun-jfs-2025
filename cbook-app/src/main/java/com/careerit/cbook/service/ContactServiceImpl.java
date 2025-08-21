package com.careerit.cbook.service;

import com.careerit.cbook.dao.ContactDao;
import com.careerit.cbook.domin.Contact;
import com.careerit.cbook.dto.ContactDto;
import com.careerit.cbook.util.ConvertorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    @Override
    public ContactDto create(ContactDto contactDto) {
        return null;
    }

    @Override
    public List<ContactDto> getContacts() {
        List<Contact> contacts = contactDao.selectAll();
        List<ContactDto> contactDtos =
                contacts.stream()
                        .map(ConvertorUtil::toContactDto).toList();
        log.info("Contact list has: {} contacts", contactDtos.size());
        return contactDtos;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public ContactDto update(ContactDto contactDto) {
        return null;
    }

    @Override
    public List<ContactDto> searchContactsByName(String name) {
        log.info("Search param is: {}", name);
        List<Contact> contacts = contactDao.searchByName(name);
        List<ContactDto> contactDtos =
                contacts.stream()
                        .map(ConvertorUtil::toContactDto).toList();
        log.info("Search param {} has {} contacts", name,contactDtos.size());
        return contactDtos;
    }

    @Override
    public ContactDto getContactById(UUID id) {
        log.info("Requested contact id is: {}", id);
        Contact contact = contactDao.selectById(id);
        ContactDto contactDto = ConvertorUtil.toContactDto(contact);
        log.info("Contact with id {} is found mobile: {}", id, contactDto.getMobile());
        return contactDto;
    }

    @Override
    public long getCount() {
        long count = contactDao.getCount();
        log.info("Total activate contact count is: {}", count);
        return count;
    }
}
