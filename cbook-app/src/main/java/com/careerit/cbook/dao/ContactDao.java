package com.careerit.cbook.dao;

import com.careerit.cbook.domin.Contact;

import java.util.List;
import java.util.UUID;

public interface ContactDao {
    Contact insert(Contact contact);
    Contact update(Contact contact);
    Contact selectById(Long id);
    List<Contact> selectAll();
    void delete(UUID id);
    List<Contact> searchByName(String name);
}
