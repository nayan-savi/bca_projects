package com.college.facebook.app.controller;

import com.college.facebook.app.dao.FriendRequestDao;
import com.college.facebook.app.dao.FriendRequestDaoImpl;
import com.college.facebook.app.dao.RegistrationDao;
import com.college.facebook.app.dao.RegistrationDaoImpl;
import com.college.facebook.app.model.FriendRequest;
import com.college.facebook.app.model.Login;
import com.college.facebook.app.model.Registration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "SendFriendRequestController")
public class SendFriendRequestController extends HttpServlet {

    private RequestDispatcher rd;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        Login login = (Login) httpSession.getAttribute("user");
        FriendRequest friendRequest = new FriendRequest();
        friendRequest.setFriendId(request.getParameter("friendId"));
        friendRequest.setUserId(login.getUserId());
        friendRequest.setUsername(login.getUsername());
        friendRequest.setRequestedDate(new Date(System.currentTimeMillis()));
        FriendRequestDao friendRequestDao = new FriendRequestDaoImpl(request);
        int row = friendRequestDao.sendRequest(friendRequest);
        if (row > 0) {
            request.setAttribute("success", "Request sent successfully.");
        } else {
            request.setAttribute("errmsg", "Request sent already.");
        }
        rd = request.getRequestDispatcher("jsp/user/sendFriendRequest.jsp");
        request.setAttribute("users", httpSession.getAttribute("users"));
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        Login login = (Login) httpSession.getAttribute("user");
        RegistrationDao registrationDao = new RegistrationDaoImpl(request);
        List<Registration> registrations = registrationDao.getActiveUsers(login.getUserId());
        RequestDispatcher rd = request.getRequestDispatcher("jsp/user/sendFriendRequest.jsp");
        request.setAttribute("users", registrations);
        httpSession.setAttribute("users", registrations);
        rd.forward(request, response);
    }
}
