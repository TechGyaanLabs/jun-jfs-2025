package com.careerit.jfs.cj.iplstatsusingdb.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public final class DatabaseUtil {
    
    private static final String CONFIG_FILE = "/application.properties";
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    
    static {
        Properties props = loadProps();
        URL = props.getProperty("db.url");
        USERNAME = props.getProperty("db.username");
        PASSWORD = props.getProperty("db.password");
        validateConfig();
    }
    
    private DatabaseUtil() {
        throw new UnsupportedOperationException("Utility class");
    }
    
    private static Properties loadProps() {
        Properties props = new Properties();
        try (var stream = DatabaseUtil.class.getResourceAsStream(CONFIG_FILE)) {
            if (stream == null) {
                throw new RuntimeException("Config file not found: " + CONFIG_FILE);
            }
            props.load(stream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config", e);
        }
        return props;
    }
    
    private static void validateConfig() {
        if (URL == null || URL.trim().isEmpty()) {
            throw new RuntimeException("Database URL not configured");
        }
        if (USERNAME == null || USERNAME.trim().isEmpty()) {
            throw new RuntimeException("Database username not configured");
        }
        if (PASSWORD == null) {
            throw new RuntimeException("Database password not configured");
        }
    }
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Connection failed", e);
        }
    }
    
    public static void close(Statement stmt, Connection conn) {
        close(null, stmt, conn);
    }
    
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        closeQuietly(rs);
        closeQuietly(stmt);
        closeQuietly(conn);
    }
    
    private static void closeQuietly(AutoCloseable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (Exception ignored) {
                // Silent close
            }
        }
    }
    
    public static boolean testConnection() {
        try (Connection conn = getConnection()) {
            return conn.isValid(5);
        } catch (Exception e) {
            return false;
        }
    }
}
