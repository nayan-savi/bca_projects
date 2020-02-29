package com.college.facebook.app.controller;

import com.college.facebook.app.dao.PostDetailsDao;
import com.college.facebook.app.dao.PostDetailsDaoImpl;
import com.college.facebook.app.model.Login;
import com.college.facebook.app.model.PostDetails;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MyBlogController")
public class MyBlogController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postId = request.getParameter("postId");
        String requestURI = request.getRequestURI();
        int row = 0;
        PostDetailsDao postDetailsDao = new PostDetailsDaoImpl(request);
        if(requestURI.equals("/deletePost")) {
            row = postDetailsDao.deletePost(postId);
        } else if(requestURI.equals("/editPost")) {
            PostDetails postDetails = postDetailsDao.editPost(postId);
            RequestDispatcher rd = request.getRequestDispatcher("jsp/post/editPost.jsp");
            request.setAttribute("postDetails", postDetails);
            request.setAttribute("level", postDetails.getVisibilityLevel());
            rd.forward(request, response);
        }
        if(row > 0) {
            dispactchTo(request, response, postDetailsDao);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostDetailsDao postDetailsDao = new PostDetailsDaoImpl(request);
        dispactchTo(request, response, postDetailsDao);
        return;
    }

    private void dispactchTo(HttpServletRequest request, HttpServletResponse response, PostDetailsDao postDetailsDao) throws ServletException, IOException {
        Login user = (Login)request.getSession().getAttribute("user");
        List<PostDetails> details = postDetailsDao.getMyBlogs(user);
        RequestDispatcher rd = request.getRequestDispatcher("jsp/post/myblog.jsp");
        request.setAttribute("posts", details);
        rd.forward(request, response);
    }
}
