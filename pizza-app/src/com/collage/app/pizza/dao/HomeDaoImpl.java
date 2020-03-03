package com.collage.app.pizza.dao;

import com.collage.app.pizza.constant.Constants;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class HomeDaoImpl implements HomeDao {

    private Connection connection;

    public HomeDaoImpl(HttpServletRequest request) {
        connection = (Connection) request.getServletContext().getAttribute(Constants.CONNECTION);
    }

    @Override
    public int like(String postId, String userId) {
        try {
            Statement statement = connection.createStatement();
            String query1 = "UPDATE POSTDETAILS SET LIKECOUNT = (LIKECOUNT + 1) WHERE POSTID = '" + postId + "'";
            String query2 = "INSERT INTO LIKEHISTORY (POSTID, USERID) VALUES ('" + postId + "','" + userId + "')";
            statement.addBatch(query1);
            statement.addBatch(query2);
            int[] ints = statement.executeBatch();
            return ints.length > 0 ? (ints[0] * ints[1]) : 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public int unlike(String postId, String userId) {
        try {
            Statement statement = connection.createStatement();
            String query1 = "UPDATE POSTDETAILS SET LIKECOUNT = (LIKECOUNT - 1) WHERE POSTID = '" + postId + "'";
            String query2 = "DELETE FROM LIKEHISTORY WHERE POSTID = '" + postId + "' AND USERID ='" + userId + "'";
            statement.addBatch(query1);
            statement.addBatch(query2);
            int[] ints = statement.executeBatch();
            return ints.length > 0 ? (ints[0] * ints[1]) : 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }




}
