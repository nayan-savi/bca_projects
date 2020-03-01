package com.college.facebook.app.dao;

import com.college.facebook.app.constant.FacebookConst;
import com.college.facebook.app.model.Login;
import com.college.facebook.app.model.PostDetails;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostDetailsDaoImpl implements PostDetailsDao {

    private Connection connection;

    public PostDetailsDaoImpl(HttpServletRequest request) {
        connection = (Connection) request.getServletContext().getAttribute(FacebookConst.CONNECTION);
    }

    @Override
    public int postDetails(PostDetails postDetails) {
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO POSTDETAILS (POSTID, USERID, USERNAME, TITLE,CREATEDDATE,PATH,MESSAGE,VISIBILITYLEVEL,LIKECOUNT) " +
                    "VALUES ('"+postDetails.getPostId()+"', '"+postDetails.getUserId()+"','"+postDetails.getUsername()+"','"+postDetails.getTitle()
                    +"',NOW(),'"+postDetails.getPath()
                    +"','"+postDetails.getMessage()+"','"+postDetails.getVisibilityLevel()+"','"+postDetails.getLike()+"')";
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public int updatePostDetails(PostDetails postDetails) {
        try {
            Statement statement = connection.createStatement();
            String query = "UPDATE POSTDETAILS SET TITLE ='"+postDetails.getTitle()
                    +"',CREATEDDATE = NOW() ,MESSAGE = '"+postDetails.getMessage()+"', VISIBILITYLEVEL = '"+postDetails.getVisibilityLevel()+"' " +
                    "WHERE POSTID = '"+postDetails.getPostId()+"'";
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public List<PostDetails> getMyBlogs(Login user) {
        try {
            List<PostDetails> list = new ArrayList();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM POSTDETAILS WHERE USERID = '"+user.getUserId()+"' ORDER BY CREATEDDATE DESC";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                PostDetails postDetails = getPostDetails(rs);
                list.add(postDetails);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private PostDetails getPostDetails(ResultSet rs) throws SQLException {
        PostDetails postDetails = new PostDetails();
        postDetails.setPostId(rs.getString("POSTID"));
        postDetails.setUserId(rs.getString("USERID"));
        postDetails.setUsername(rs.getString("USERNAME"));
        postDetails.setTitle(rs.getString("TITLE"));
        postDetails.setPath(rs.getString("PATH"));
        postDetails.setMessage(rs.getString("MESSAGE"));
        postDetails.setVisibilityLevel(rs.getInt("VISIBILITYLEVEL"));
        postDetails.setLike(rs.getInt("LIKECOUNT"));
        return postDetails;
    }

    @Override
    public int deletePost(String postId) {
         try {
             Statement statement = connection.createStatement();
             String query = "DELETE FROM POSTDETAILS WHERE POSTID = '"+postId+"'";
             return statement.executeUpdate(query);
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
        return 0;
    }

    @Override
    public PostDetails editPost(String postId) {
        PostDetails postDetails = null;
         try {
             Statement statement = connection.createStatement();
             String query = "SELECT * FROM POSTDETAILS WHERE POSTID = '"+postId+"'";
             ResultSet rs = statement.executeQuery(query);
             while(rs.next()) {
                  postDetails = getPostDetails(rs);
             }
             return postDetails;
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
        return null;
    }
}
