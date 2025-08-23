package com.careerit.cbook.dao;

import com.careerit.cbook.domin.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ContactRowMapper implements RowMapper<Contact> {

    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        UUID id = UUID.fromString(rs.getString("id"));
        String name = rs.getString("name");
        String email = rs.getString("email");
        String mobile = rs.getString("mobile");
        boolean deleted = rs.getBoolean("deleted");
        Contact contact = new Contact();
        contact.setId(id);
        contact.setName(name);
        contact.setEmail(email);
        contact.setMobile(mobile);
        contact.setDeleted(deleted);
        return contact;
    }
}
