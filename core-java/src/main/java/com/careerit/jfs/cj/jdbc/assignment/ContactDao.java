package com.careerit.jfs.cj.jdbc.assignment;

import java.util.List;
import java.util.Optional;

public interface ContactDao {
    
    Contact create(Contact contact);

    Optional<Contact> findByMobile(String mobile);
    
    Optional<Contact> findById(Long id);
    
    List<Contact> findAll();
    
    Contact update(Contact contact);
    
    boolean delete(Long id);
    
    List<Contact> searchByName(String name);
}
