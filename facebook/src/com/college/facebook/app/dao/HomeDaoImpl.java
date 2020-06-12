package com.college.facebook.app.dao;

import com.college.facebook.app.constant.FacebookConst;
import com.college.facebook.app.model.PostDetails;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HomeDaoImpl implements HomeDao {

    private Connection connection;

    public HomeDaoImpl(HttpServletRequest request) {
        connection = (Connection) request.getServletContext().getAttribute(FacebookConst.CONNECTION);
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

    @Override
    public List<PostDetails> getPosts(String userId) {
        List<PostDetails> list = new ArrayList();
        try {
            Statement statement1 = connection.createStatement();
            Statement statement2 = connection.createStatement();
            String query = "SELECT * FROM POSTDETAILS WHERE POSTID IN " +
                    "(SELECT POSTID FROM POSTDETAILS WHERE `VISIBILITYLEVEL` IN (1, 2) AND USERID = '"+userId+"'" +
                    " UNION SELECT POSTID FROM POSTDETAILS WHERE `VISIBILITYLEVEL` = 3 UNION SELECT POSTID FROM POSTDETAILS WHERE USERID IN (" +
                    " SELECT REQUESTORID FROM LINKEDFRIENDS WHERE USERID = '"+userId+"') " +
                    "AND `VISIBILITYLEVEL` <> 1) ORDER BY CREATEDDATE DESC";
            ResultSet rs = statement1.executeQuery(query);
            while (rs.next()) {
                PostDetails postDetails = new PostDetails();
                postDetails.setPostId(rs.getString("POSTID"));
                postDetails.setUserId(rs.getString("USERID"));
                postDetails.setUsername(rs.getString("USERNAME"));
                postDetails.setTitle(rs.getString("TITLE"));
                postDetails.setMessage(rs.getString("MESSAGE"));
                postDetails.setPath(rs.getString("PATH"));
                postDetails.setVisibilityLevel(rs.getInt("VISIBILITYLEVEL"));
                postDetails.setLike(rs.getInt("LIKECOUNT"));
                postDetails.setEnable(true);
                String query2 = "SELECT * FROM LIKEHISTORY WHERE POSTID = '"+postDetails.getPostId()+"' AND USERID = '"+userId+"'";
                ResultSet resultSet = statement2.executeQuery(query2);
                while(resultSet.next()) {
                    postDetails.setEnable(false);
                }
                list.add(postDetails);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }


}
