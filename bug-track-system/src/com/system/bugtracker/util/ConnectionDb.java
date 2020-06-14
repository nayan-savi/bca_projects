package com.system.bugtracker.util;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb {

    private static Connection connection = null;

    private ConnectionDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bugtracksystem", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            new ConnectionDb();
        }
        return connection;
    }

}
