package com.careerit.cbook.service;

import com.careerit.cbook.dao.ContactDao;
import com.careerit.cbook.domin.Contact;
import com.careerit.cbook.dto.ContactDto;
import com.careerit.cbook.exception.ContactAlreadyExistsException;
import com.careerit.cbook.exception.ContactNotFoundException;
import com.careerit.cbook.records.ContactCount;
import com.careerit.cbook.util.ConvertorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    @Override
    public ContactDto create(ContactDto contactDto) {
        Assert.notNull(contactDto, "ContactDto is required");
        Assert.notNull(contactDto.getName(), "Name is required");
        Assert.notNull(contactDto.getEmail(), "Email is required");
        Assert.notNull(contactDto.getMobile(), "Mobile is required");

        if(contactDao.isMobileExists(contactDto.getMobile())) {
            throw new ContactAlreadyExistsException("Contact already exists with mobile: " + contactDto.getMobile());
        }
        Contact contact = contactDao.insert(ConvertorUtil.toContactDomain(contactDto));
        ContactDto createdContactDto = ConvertorUtil.toContactDto(contact);
        log.info("Contact created with id: {}", createdContactDto.getId());
        return createdContactDto;
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
        Assert.notNull(id, "Id is required");
        if(contactDao.selectById(id) != null) {
            contactDao.delete(id);
            log.info("Contact with id {} is deleted", id);
            return;
        }
        throw new ContactNotFoundException("Contact not found with id: " + id);
    }

    @Override
    public ContactDto update(ContactDto contactDto) {
        Assert.notNull(contactDto, "ContactDto is required");
        Assert.notNull(contactDto.getId(), "Id is required");
        Assert.notNull(contactDto.getName(), "Name is required");
        Assert.notNull(contactDto.getEmail(), "Email is required");
        Assert.notNull(contactDto.getMobile(), "Mobile is required");

        Contact existingContact = contactDao.selectByMobile(contactDto.getMobile());

        if(existingContact != null && !existingContact.getId().equals(contactDto.getId())) {
            log.error("Contact already exists with mobile: {}", contactDto.getMobile());
            throw new ContactAlreadyExistsException("Contact already exists with mobile: " + contactDto.getMobile());
        }
        Contact contact = contactDao.update(ConvertorUtil.toContactDomain(contactDto));
        ContactDto updatedContactDto = ConvertorUtil.toContactDto(contact);
        log.info("Contact ({}) is updated successfully", updatedContactDto.getId());
        return updatedContactDto;
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
    public ContactCount getCount() {
        long count = contactDao.getCount();
        log.info("Total activate contact count is: {}", count);
        return new ContactCount(count);
    }
}
