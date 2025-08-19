package com.careerit.jfs.cj.jdbc.assignment;

public final class ContactQueries {

    public static final String ADD_CONTACT = "INSERT INTO contact(name,mobile,email) VALUES(?,?,?)";
    public static final String FIND_BY_ID = "SELECT * FROM contact WHERE id = ?";
    public static final String FIND_ALL = "SELECT * FROM contact WHERE deleted = false";
    public static final String UPDATE_CONTACT = "UPDATE contact SET name = ?, email = ?, mobile = ? WHERE id = ?";
    public static final String DELETE_CONTACT = "UPDATE contact SET deleted = true WHERE id = ?";
    public static final String SEARCH_BY_NAME = "SELECT * FROM contact WHERE lower(name) LIKE lower(?) AND deleted = false";
}
