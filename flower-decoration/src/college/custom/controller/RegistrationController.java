package college.custom.controller;

import college.custom.dao.RegistrationDao;
import college.custom.dao.RegistrationDaoImpl;
import college.custom.model.Registration;
import college.custom.util.ConnectionDb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "RegistrationController")
public class RegistrationController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        Registration registration = new Registration();
        registration.setName(request.getParameter("name"));
        registration.setAddress(request.getParameter("adress"));
        registration.setContactNo(request.getParameter("contactNo"));
        registration.setEmailId(request.getParameter("emailId"));
        registration.setUsername(request.getParameter("username"));
        registration.setPassword(request.getParameter("password"));
        registration.setLevel(3); // this is user registration
        registration.setStatus(request.getParameter("status"));
        registration.setDescription(request.getParameter("description"));
        RegistrationDao registrationDao = new RegistrationDaoImpl();
        int row = registrationDao.save(registration);

        if (row > 0) {
            rd = request.getRequestDispatcher("jsp/login/login.jsp");
            request.setAttribute("success", "User registered successfully.");
            rd.forward(request, response);
        } else {
            rd = request.getRequestDispatcher("jsp/login/registration.jsp");
            request.setAttribute("errmsg", "User already exits.");
            rd.forward(request, response);
        }

    }

}
