package com.college.facebook.app.controller;

import com.college.facebook.app.dao.LoginDao;
import com.college.facebook.app.dao.LoginDaoImpl;
import com.college.facebook.app.model.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginController")
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        RequestDispatcher rd = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LoginDao loginDao = new LoginDaoImpl();
        Login login = loginDao.login(username, password);
        session.setAttribute("user", login);
        if(null != login.getUserId()) {
            rd = request.getRequestDispatcher("jsp/user/userHome.jsp");
        } else {
            rd = request.getRequestDispatcher("jsp/login/login.jsp");
            request.setAttribute("errmsg", "Invalid username and password ");
        }
        rd.forward(request, response);
    }

}
