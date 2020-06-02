package com.voilation.traffic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.voilation.traffic.dao.RegistrationDao;
import com.voilation.traffic.dao.RegistrationDaoImpl;
import com.voilation.traffic.model.Registration;

@WebServlet(name = "EmployeeController")
public class EmployeeController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		RegistrationDao dao = new RegistrationDaoImpl();
		Registration registration = new Registration();
		registration.setPassword(request.getParameter("password"));
		registration.setUsername((String) session.getAttribute("username"));
		int row = dao.updatePwd(registration);

		if (row > 0) {
			request.setAttribute("success", "Password Changed successfully.");
			response.sendRedirect(request.getContextPath());
		} else {
			rd = request.getRequestDispatcher("jsp/employee/employeeHome.jsp");
			request.setAttribute("errmsg", "Error while changing password.");
			rd.forward(request, response);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("jsp/employee/changePwd.jsp");
		rd.forward(request, response);
	}

}
