package com.college.facebook.app.controller;

import com.college.facebook.app.dao.PostDetailsDao;
import com.college.facebook.app.dao.PostDetailsDaoImpl;
import com.college.facebook.app.model.Login;
import com.college.facebook.app.model.PostDetails;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PostController")
@MultipartConfig
public class PostController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostDetails postDetails = new PostDetails();
        Login user = (Login) request.getSession().getAttribute("user");
        postDetails.setUserId(user.getUserId());
        postDetails.setUsername(request.getParameter("username"));
        postDetails.setTitle(request.getParameter("title"));
        postDetails.setPath("");
        postDetails.setMessage(request.getParameter("message"));
        postDetails.setVisibilityLevel(Integer.parseInt(request.getParameter("visibilityLevel")));
        postDetails.setLike(0);

        PostDetailsDao postDetailsDao = new PostDetailsDaoImpl(request);
        int row = postDetailsDao.postDetails(postDetails);

        if(row > 0) {
            request.setAttribute("success", "Posted successfully.");
        } else {
            request.setAttribute("errmsg", "Post data failed.");
        }
        RequestDispatcher rd = request.getRequestDispatcher("jsp/post/post.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("jsp/post/post.jsp");
        rd.forward(request, response);
    }
}
