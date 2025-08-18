package com.careerit.jfs.cj.jdbc.assignment;

import com.careerit.jfs.cj.jdbc.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.careerit.jfs.cj.jdbc.assignment.ContactQueries.*;

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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            ps = con.prepareStatement("SELECT * FROM contact WHERE mobile = ?");
            ps.setString(1, mobile);
            rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(mapToContact(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(rs, ps, con);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Contact> findById(Long id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(FIND_BY_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(mapToContact(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(rs, ps, con);
        }
        return Optional.empty();
    }

    @Override
    public List<Contact> findAll() {
        List<Contact> list = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = ConnectionUtil.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(FIND_ALL);
            while (rs.next()) {
                list.add(mapToContact(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(rs, st, con);
        }
        return list;
    }

    @Override
    public Contact update(Contact contact) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(UPDATE_CONTACT);
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getEmail());
            ps.setString(3, contact.getMobile());
            ps.setLong(4, contact.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(null, ps, con);
        }
        return contact;
    }

    @Override
    public boolean delete(Long id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(DELETE_CONTACT);
            ps.setLong(1, id);
            int count = ps.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(null, ps, con);
        }
        return false;
    }

    @Override
    public List<Contact> searchByName(String name) {
        List<Contact> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(SEARCH_BY_NAME);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapToContact(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(rs, ps, con);
        }
        return list;
    }

    private Contact mapToContact(ResultSet rs) throws SQLException {
        return Contact.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .email(rs.getString("email"))
                .mobile(rs.getString("mobile"))
                .deleted(rs.getBoolean("deleted"))
                .build();
    }
}
