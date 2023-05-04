package org.example.connectionManager;

import org.example.propertiesUtil.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String PASSWORD_KEY = "password";
    private static final String USERNAME_KEY = "username";
    private static final String URL_KEY = "url";

    public ConnectionManager() {

    }


    public Connection openConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("java.sql.Driver");
            conn = DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USERNAME_KEY),
                    PropertiesUtil.get(PASSWORD_KEY)
            );
            System.out.println("Connection OK");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;

    }
}
