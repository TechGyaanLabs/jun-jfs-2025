package com.careerit.jfs.cj.jdbc;

import java.sql.*;
import static com.careerit.jfs.cj.jdbc.DbQueries.*;

public class DbManager {

    public static void main(String[] args) {
        //createTable();
        // addEmployees();
        showAllEmployees();
    }

    public static void createTable() {
        Connection conn = null;
        Statement st = null;
        try {
            conn = ConnectionUtil.getConnection();
            st = conn.createStatement();
            boolean result = st.execute(CREATE_EMPLOYEE_TABLE);
            String message = result ? "Table created successfully" : "Table already exists";
            System.out.println(message);
        } catch (SQLException e) {
            System.out.println("Create table failed " + e);
        } finally {
            ConnectionUtil.close(st, conn);
        }
    }

    public static void addEmployee(String name, double salary, String department) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(INSERT_EMPLOYEE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setString(3, department);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int generatedKeys = rs.getInt(1);
                System.out.println("Employee added successfully with ID: " + generatedKeys);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(rs, ps, conn);
        }
    }

    private static void showAllEmployees() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = ConnectionUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(SELECT_ALL_EMPLOYEES);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("-".repeat(100));
            }
        } catch (SQLException e) {
            System.out.println("Show all employees failed " + e);
        } finally {
            ConnectionUtil.close(rs, st, conn);
        }
    }

    private static void addEmployees() {
        addEmployee("Krish", 150000.0, "IT");
        addEmployee("Manoj", 100000.0, "IT");
        addEmployee("Praveen", 100000.0, "IT");
        addEmployee("Ramesh", 100000.0, "IT");
        addEmployee("Ramesh", 100000.0, "IT");
    }
}
