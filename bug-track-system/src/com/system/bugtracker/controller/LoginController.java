package com.system.bugtracker.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.bugtracker.dao.LoginDao;
import com.system.bugtracker.dao.LoginDaoImpl;
import com.system.bugtracker.model.Employee;

import java.io.IOException;

@WebServlet(name = "LoginController")
public class LoginController extends HttpServlet {

	public LoginController() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		RequestDispatcher rd = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		LoginDao loginDao = new LoginDaoImpl();
		Employee employee = loginDao.login(username, password);
		int level = employee.getLevel();
		if (level > 0) {
			session.setAttribute("username", employee.getUsername());
			session.setAttribute("name", employee.getName());
			if (level == 1) {
				rd = request.getRequestDispatcher("jsp/admin/adminHome.jsp");
			} else if (level == 2 || level == 3) {
				session.setAttribute("employeeId", employee.getEmployeeId());
				session.setAttribute("active", employee.getActive());
				session.setAttribute("designation", employee.getLevel());
				rd = request.getRequestDispatcher("jsp/employee/employeeHome.jsp");
			}
		} else {
			rd = request.getRequestDispatcher("jsp/login/login.jsp");
			request.setAttribute("errmsg", "Invalid username and password ");
		}
		rd.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String anchor = request.getParameter("anchor");
		RequestDispatcher rd;
		if (anchor.equalsIgnoreCase("logOff")) {
			rd = request.getRequestDispatcher("jsp/logout.jsp");
			rd.forward(request, response);
		}
	}

}
