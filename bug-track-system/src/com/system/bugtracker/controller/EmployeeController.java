package com.system.bugtracker.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.bugtracker.dao.EmployeeDao;
import com.system.bugtracker.dao.EmployeeDaoImpl;
import com.system.bugtracker.model.Employee;

@WebServlet(name = "RegistrationController")
public class EmployeeController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String anchor = request.getParameter("anchor");
		String employeeId = request.getParameter("employeeId");
		String data = "";
		RequestDispatcher rd;
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		int row = -1;
		if (anchor.equalsIgnoreCase("addEmployee")) {
			Employee employee = getEmployee(request);
			row = employeeDao.save(employee);
		} else if (anchor.equals("modifyEmployee")) {
			Employee employee = employeeDao.getEmployeeById(employeeId);
			request.setAttribute("employee", employee);
			rd = request.getRequestDispatcher("jsp/admin/modifyEmployee.jsp");
			rd.forward(request, response);
		} else if (anchor.equals("updateEmployee")) {
			Employee employee = getEmployee(request);
			employee.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
			row = employeeDao.updateEmployee(employee);
			data = "update";
		} else if (anchor.equalsIgnoreCase("cancelEmployee")) {
			response.sendRedirect(request.getContextPath() + "/viewEmployee?anchor=viewEmployee");
		} else if(anchor.equals("updatePwd")) {
			Employee employee = new Employee();
			employee.setPassword(request.getParameter("password"));
			employee.setUsername((String) session.getAttribute("username"));
			row = employeeDao.updatePwd(employee);
			data = "emp";
		}
		
		if (row > 0) {
			if(data.equals("emp")) {
				response.sendRedirect(request.getContextPath());
			} else {
				rd = request.getRequestDispatcher("jsp/admin/adminHome.jsp");
				request.setAttribute("success", "Employee added successfully.");
				rd.forward(request, response);
			}
		} else if (row == 0) {
			rd = request.getRequestDispatcher("jsp/login/login.jsp");
			request.setAttribute("errmsg", "User already exits.");
			rd.forward(request, response);
		}

	}

	private Employee getEmployee(HttpServletRequest request) {
		Employee employee = new Employee();
		employee.setName(request.getParameter("name"));
		employee.setAddress(request.getParameter("address"));
		employee.setContactNo(request.getParameter("contactNo"));
		employee.setEmailId(request.getParameter("emailId"));
		employee.setUsername(request.getParameter("username"));
		employee.setPassword(request.getParameter("password"));
		employee.setLevel(Integer.parseInt(request.getParameter("level"))); // this is user desination
		employee.setActive(request.getParameter("active"));
		return employee;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String anchor = request.getParameter("anchor");
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		if (anchor.equalsIgnoreCase("addEmployee")) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/admin/addEmployee.jsp");
			rd.forward(request, response);
		} else if (anchor.equalsIgnoreCase("viewEmployee")) {
			List<Employee> employees = employeeDao.viewEmployees(false);
            RequestDispatcher rd = request.getRequestDispatcher("jsp/admin/viewEmployee.jsp");
            request.setAttribute("employees", employees);
            rd.forward(request, response);
		} else if(anchor.equalsIgnoreCase("changePwd")) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/employee/changePwd.jsp");
			rd.forward(request, response);
		} 
	}

}
