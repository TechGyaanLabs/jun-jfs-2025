package com.careerit.jfs.cj.jdbc;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Utility class for database connection management
 */
public final class ConnectionUtil {

    private static final String CONFIG_FILE = "/application.properties";
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    private static final String DB_URL = "db.url";
    private static final String DB_USERNAME = "db.username";
    private static final String DB_PASSWORD = "db.password";

    static {
        Properties props = loadProps();
        URL = props.getProperty(DB_URL);
        USERNAME = props.getProperty(DB_USERNAME);
        PASSWORD = props.getProperty(DB_PASSWORD);
        validateConfig();
    }

    private ConnectionUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    private static Properties loadProps() {
        Properties props = new Properties();
        try (var stream = ConnectionUtil.class.getResourceAsStream(CONFIG_FILE)) {
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

    public static Connection getConnection(boolean autoCommit) {
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            conn.setAutoCommit(autoCommit);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Connection failed", e);
        }
    }

    public static void close(Statement stmt, Connection conn) {
        closeQuietly(stmt, conn);
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        closeQuietly(rs, stmt, conn);
    }

    private static void closeQuietly(AutoCloseable... resources) {
        if (resources == null) {
            return;
        }
        
        for (AutoCloseable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception ignored) {
                    System.out.println("Failed to close resource: " + resource);
                }
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

    public static String getConnectionInfo() {
        return String.format("URL: %s, User: %s", 
                           URL != null ? URL.replaceAll("password=[^&]*", "password=***") : "null", 
                           USERNAME != null ? USERNAME : "null");
    }
}
