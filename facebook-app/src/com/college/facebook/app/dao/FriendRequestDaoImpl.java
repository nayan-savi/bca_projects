package com.college.facebook.app.dao;

import com.college.facebook.app.constant.FacebookConst;
import com.college.facebook.app.model.FriendRequest;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FriendRequestDaoImpl implements FriendRequestDao {

    private Connection connection;

    public FriendRequestDaoImpl(HttpServletRequest request) {
        connection = (Connection) request.getServletContext().getAttribute(FacebookConst.CONNECTION);
    }

    @Override
    public int sendRequest(FriendRequest friendRequest) {
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO FRIENDREQUESTS (`USERID`,`USERNAME`,`FRIENDID`,`REQUESTEDDATE`) " +
                    "VALUES('"+friendRequest.getUserId()+"','"+friendRequest.getUsername()+"','"
                    +friendRequest.getFriendId()+"','"+friendRequest.getRequestedDate()+"')";
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
