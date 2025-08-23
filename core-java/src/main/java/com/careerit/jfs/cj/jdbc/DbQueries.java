package com.careerit.jfs.cj.jdbc;

/**
 * Constants file containing all database queries
 */
public final class DbQueries {
    
    private DbQueries() {
        throw new UnsupportedOperationException("Utility class");
    }
    
    // Employee table queries
    public static final String CREATE_EMPLOYEE_TABLE = """
            CREATE TABLE IF NOT EXISTS EMPLOYEE (
                id SERIAL PRIMARY KEY,
                name VARCHAR(50) NOT NULL,
                salary DECIMAL(10, 2) NOT NULL,
                department VARCHAR(50) NOT NULL
            )
            """;
    
    public static final String INSERT_EMPLOYEE = """
            INSERT INTO employee (name, salary, department)
            VALUES (?, ?, ?)
            """;
    
    public static final String SELECT_ALL_EMPLOYEES = """
            SELECT id, name, salary, department 
            FROM EMPLOYEE
            """;
}
