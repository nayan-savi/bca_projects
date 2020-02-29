package com.college.facebook.app.controller;

import com.college.facebook.app.dao.HomeDao;
import com.college.facebook.app.dao.HomeDaoImpl;
import com.college.facebook.app.model.Login;
import com.college.facebook.app.model.PostDetails;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeController")
public class HomeController extends HttpServlet {

    List<PostDetails> postDetails;

    public HomeController() {
        postDetails = new ArrayList<>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postId = request.getParameter("likeUnlike");
        HomeDao homeDao = new HomeDaoImpl(request);
        RequestDispatcher rd;
        Login user = (Login) request.getSession().getAttribute("user");
        String action = request.getRequestURI();
        if (action.equalsIgnoreCase("/like")) {
            int row = homeDao.like(postId, user.getUserId());
            if (row == 0) {
                request.setAttribute("errmsg", "Already liked it.");
            }
        } else if (action.equalsIgnoreCase("/unlike")) {
            int row = homeDao.unlike(postId, user.getUserId());
            if (row == 0) {
                request.setAttribute("errmsg", "Already unliked it.");
            }
        }
        postDetails = homeDao.getPosts(user.getUserId());
        request.setAttribute("posts", postDetails);
        rd = request.getRequestDispatcher("jsp/user/userHome.jsp");
        rd.forward(request, response);
    }
}
