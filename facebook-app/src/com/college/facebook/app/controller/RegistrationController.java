package com.college.facebook.app.controller;

import com.college.facebook.app.dao.RegistrationDao;
import com.college.facebook.app.dao.RegistrationDaoImpl;
import com.college.facebook.app.model.Registration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationController")
public class RegistrationController extends HttpServlet {

    private RequestDispatcher rd;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Registration registration =  new Registration();
        registration.setName(request.getParameter("name"));
        registration.setAddress(request.getParameter("address"));
        registration.setContactNo(request.getParameter("contactNo"));
        registration.setEmailId(request.getParameter("emailId"));
        registration.setUsername(request.getParameter("username"));
        registration.setPassword(request.getParameter("password"));
        registration.setActive(true);

        RegistrationDao registrationDao = new RegistrationDaoImpl(request);
        int row = registrationDao.save(registration);
        if(row > 0) {
            rd = request.getRequestDispatcher("jsp/login/login.jsp");
            request.setAttribute("success", "User registered successfully.");
            rd.forward(request, response);
        } else {
            rd = request.getRequestDispatcher("jsp/login/registration.jsp");
            request.setAttribute("errmsg", "User already exits.");
            rd.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        rd = request.getRequestDispatcher("jsp/login/registration.jsp");
        rd.forward(request, response);
    }
}
