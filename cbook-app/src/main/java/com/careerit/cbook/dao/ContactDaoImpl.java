package com.careerit.cbook.dao;

import com.careerit.cbook.domin.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ContactDaoImpl implements ContactDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Contact insert(Contact contact) {
        return null;
    }

    @Override
    public Contact update(Contact contact) {
        return null;
    }

    @Override
    public Contact selectById(UUID id) {
        String sql = "select id,name,email,mobile,deleted from contact where id = ?";
        return jdbcTemplate.queryForObject(sql,new ContactRowMapper(),id);
    }

    @Override
    public List<Contact> selectAll() {
        String sql = "select id,name,email,mobile,deleted from contact where deleted = false";
        return jdbcTemplate.query(sql,new ContactRowMapper());
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<Contact> searchByName(String name) {
        String sql = "select id,name,email,mobile,deleted from contact where name like ? and deleted = false";
        return jdbcTemplate.query(sql,new ContactRowMapper(),"%"+name+"%");
    }

    @Override
    public long getCount() {
        String sql = "select count(*) from contact where deleted = false";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        return count!= null ? count : 0;
    }
}
