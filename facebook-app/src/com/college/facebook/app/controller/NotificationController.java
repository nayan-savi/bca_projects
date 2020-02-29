package com.college.facebook.app.controller;

import com.college.facebook.app.dao.NotificationDao;
import com.college.facebook.app.dao.NotificationDaoImpl;
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
import java.util.List;

@WebServlet(name = "NotificationController")
public class NotificationController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        HttpSession session = request.getSession();
        String anchor = request.getParameter("anchor");
        String friendId = request.getParameter("friendId");
        Login user = (Login) session.getAttribute("user");
        String userId = user.getUserId();
        int row;
        NotificationDao notificationDao = new NotificationDaoImpl(request);
        if(anchor.equalsIgnoreCase("confirm")) {
            row = notificationDao.confirmNotification(userId, friendId);
            if(row == 0) {
                request.setAttribute("errmsg", "Issue while confirming request.");
            } else {
                request.setAttribute("success", "Confirmed the request successfully.");
            }
        } else if(anchor.equalsIgnoreCase("delete")) {
            row = notificationDao.deleteNotification(userId, friendId);
            if(row == 0) {
                request.setAttribute("errmsg", "Issue while deleting request.");
            } else {
                request.setAttribute("success", "Deleted the request successfully.");
            }
        }
        rd = request.getRequestDispatcher("jsp/notification/userNotification.jsp");
        request.setAttribute("friendRequests", notificationDao.getNotification(user));
        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Login user = (Login) session.getAttribute("user");
        NotificationDao notificationDao = new NotificationDaoImpl(request);
        List<Registration> friendRequests = notificationDao.getNotification(user);
        RequestDispatcher rd = request.getRequestDispatcher("jsp/notification/userNotification.jsp");
        request.setAttribute("friendRequests", friendRequests);
        session.setAttribute("friendRequests", friendRequests);
        rd.forward(request, response);
    }
}
