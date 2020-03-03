package com.collage.app.pizza.controller;

import com.collage.app.pizza.dao.HomeDao;
import com.collage.app.pizza.dao.HomeDaoImpl;
import com.collage.app.pizza.model.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeController")
public class HomeController extends HttpServlet {


    public HomeController() {

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
        rd = request.getRequestDispatcher("jsp/user/userHome.jsp");
        rd.forward(request, response);
    }
}
