package com.collage.app.pizza.config;


import com.collage.app.pizza.constant.Constants;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class ConnectionListener implements ServletContextListener {

    private static Connection connection = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        ctx.setAttribute(Constants.CONNECTION, ConnectionListener.getConnection());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        Connection con = (Connection) servletContextEvent.getServletContext().getAttribute(Constants.CONNECTION);
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ConnectionListener() {
        try {
            Class.forName(Constants.FOR_NAME);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/facebookapp", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            new ConnectionListener();
        }
        return connection;
    }
}
