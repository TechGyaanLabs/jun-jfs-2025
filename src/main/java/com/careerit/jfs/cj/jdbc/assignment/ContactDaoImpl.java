package com.careerit.jfs.cj.jdbc.assignment;

import com.careerit.jfs.cj.jdbc.ConnectionUtil;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import static com.careerit.jfs.cj.jdbc.assignment.ContactQueries.ADD_CONTACT;

public class ContactDaoImpl implements ContactDao {
    @Override
    public Contact create(Contact contact) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(ADD_CONTACT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getMobile());
            ps.setString(3, contact.getEmail());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                long generatedKeys = rs.getLong(1);
                contact.setId(generatedKeys);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(rs, ps, con);
        }
        return contact;
    }

    @Override
    public Optional<Contact> findByMobile(String mobile) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement("select * from contact where mobile = ?");
            ps.setString(1, mobile);
            rs = ps.executeQuery();
            if (rs.next()) {
                Contact contact = mapToContact(rs);
                return Optional.of(contact);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.close(rs, ps, con);
        }
        return Optional.empty();

    }

    @Override
    public Optional<Contact> findById(Long id) {

        return Optional.empty();
    }

    @Override
    public List<Contact> findAll() {
        return List.of();
    }

    @Override
    public Contact update(Contact contact) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Contact> searchByName(String name) {
        return List.of();
    }

    private Contact mapToContact(ResultSet rs) throws SQLException {
            Contact contact = new Contact();
            contact.setId(rs.getLong("id"));
            contact.setName(rs.getString("name"));
            contact.setEmail(rs.getString("email"));
            contact.setMobile(rs.getString("mobile"));
            contact.setDeleted(rs.getBoolean("deleted"));
            return contact;
    }
}
