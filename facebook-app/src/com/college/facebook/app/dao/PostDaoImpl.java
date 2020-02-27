package com.college.facebook.app.dao;

import com.college.facebook.app.constant.FacebookConst;
import com.college.facebook.app.model.PostDetails;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PostDaoImpl implements PostDao {

    private Connection connection;

    public PostDaoImpl(HttpServletRequest request) {
        connection = (Connection) request.getServletContext().getAttribute(FacebookConst.CONNECTION);
    }

    @Override
    public int postDetails(PostDetails postDetails) {
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO POSTDETAILS (USERID, USERNAME, TITLE,CREATEDDATE,PATH,MESSAGE,VISIBILITYLEVEL,LIKECOUNT) " +
                    "VALUES ('"+postDetails.getUserId()+"','"+postDetails.getUsername()+"','"+postDetails.getTitle()
                    +"',NOW(),'"+postDetails.getPath()
                    +"','"+postDetails.getMessage()+"','"+postDetails.getVisibilityLevel()+"','"+postDetails.getLike()+"')";
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
