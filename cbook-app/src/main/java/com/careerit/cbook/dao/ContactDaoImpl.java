package com.careerit.cbook.dao;

import com.careerit.cbook.domin.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public class ContactDaoImpl implements ContactDao {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Contact insert(Contact contact) {
        String sql = "insert into contact(id,name,email,mobile) values(?,?,?,?)";
        UUID id = UUID.randomUUID();
        jdbcTemplate.update(sql, id, contact.getName(), contact.getEmail(), contact.getMobile());
        contact.setId(id);
        return contact;
    }

    @Override
    public Contact update(Contact contact) {
        String sql = "update contact set name = ?, email = ?, mobile = ? where id = ?";
        jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getMobile(), contact.getId());
        return contact;
    }

    @Override
    public Contact selectById(UUID id) {
        String sql = "select id,name,email,mobile,deleted from contact where id = ?";
        return jdbcTemplate.queryForObject(sql, new ContactRowMapper(), id);
    }

    @Override
    public List<Contact> selectAll() {
        String sql = "select id,name,email,mobile,deleted from contact where deleted = false";
        return jdbcTemplate.query(sql, new ContactRowMapper());
    }

    @Override
    public void delete(UUID id) {
        String sql = "update contact set deleted = true where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Contact> searchByName(String name) {
        String sql = "select id,name,email,mobile,deleted from contact where name like ? and deleted = false";
        return jdbcTemplate.query(sql, new ContactRowMapper(), "%" + name + "%");
    }

    @Override
    public long getCount() {
        String sql = "select count(*) from contact where deleted = false";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        return count != null ? count : 0;
    }

    @Override
    public boolean isMobileExists(String mobile) {
        String sql = "select count(*) from contact where mobile = ? and deleted = false";
        Long count = jdbcTemplate.queryForObject(sql, Long.class, mobile);
        return count != null && count > 0;
    }

    @Override
    public Contact selectByMobile(String mobile) {
        String sql = "select id,name,email,mobile,deleted from contact where mobile = ? and deleted = false";
        return jdbcTemplate.queryForObject(sql, new ContactRowMapper(), mobile);
    }
}
