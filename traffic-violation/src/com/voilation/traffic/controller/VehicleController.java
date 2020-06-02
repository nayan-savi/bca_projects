package com.voilation.traffic.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voilation.traffic.dao.RegistrationDao;
import com.voilation.traffic.dao.RegistrationDaoImpl;
import com.voilation.traffic.dao.VehicleDao;
import com.voilation.traffic.dao.VehicleDaoImpl;
import com.voilation.traffic.model.Complaint;
import com.voilation.traffic.model.Registration;
import com.voilation.traffic.model.Vehicle;

@WebServlet(name = "VehicleController")
public class VehicleController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String anchor = request.getParameter("anchor");
		String vehicleId = request.getParameter("vehicleId");
		String vehicleNo = request.getParameter("no");
		String data = "";
		int row = -1;
		VehicleDao vehicleDao = new VehicleDaoImpl();
		if (anchor.equals("addVehicle")) {
			Vehicle vehicle = getVehicle(request);
			row = vehicleDao.saveVehicle(vehicle);
			data = "Vehicle";
		} else if(anchor.equals("modifyVehicle")) {
			Vehicle vehicle = vehicleDao.getVehicleById(vehicleId);
            request.setAttribute("vehicle", vehicle);
            RequestDispatcher rd = request.getRequestDispatcher("jsp/rto/modifyVehicle.jsp");
            rd.forward(request, response);
		} else if(anchor.equals("updateVehicle")) {
			Vehicle vehicle = getVehicle(request);
			vehicle.setVehicleId(Integer.parseInt(request.getParameter("vehicleId")));
			row = vehicleDao.updateVehicle(vehicle);
            data = "update";
		} else if (anchor.equalsIgnoreCase("cancelVehicle")) {
            response.sendRedirect(request.getContextPath()+"/viewVehicle?anchor=viewVehicle");
        } else if(anchor.equals("searchVehicle")) {
        	Vehicle vehicle = vehicleDao.getVehicleByNo(vehicleNo);
        	RequestDispatcher rd = request.getRequestDispatcher("jsp/employee/searchVehicle.jsp");
            request.setAttribute("vehicle", vehicle);
            rd.forward(request, response);
        } else if (anchor.equals("addEmployee")) {
        	Registration employee = getRegistration(request);
        	row = vehicleDao.saveEmployee(employee);
        	data = "employee"; 
        } else if(anchor.equals("modifyEmployee")) {
        	String username = request.getParameter("username");
        	Registration employee = vehicleDao.getEmployeeByUsername(username);
        	request.setAttribute("employee", employee);
            RequestDispatcher rd = request.getRequestDispatcher("jsp/rto/modifyEmployee.jsp");
            rd.forward(request, response);
        } else if(anchor.equals("updateEmployee")) {
			Registration employee = getRegistration(request);
			row = vehicleDao.updateEmployee(employee);
            data = "updateEmp";
		} 

		if (row > 0) {
			if(data.equals("updateEmp")) {
				response.sendRedirect(request.getContextPath()+"/viewEmployee?anchor=viewEmployee");
			} else if(data.equals("update")) {
				response.sendRedirect(request.getContextPath()+"/viewVehicle?anchor=viewVehicle");
			} else if(data.equals("employee")) {
				request.setAttribute("success", "Employee added successfully.");
				RequestDispatcher rd = request.getRequestDispatcher("jsp/rto/adminRtoHome.jsp");
				rd.forward(request, response);
			}	else {
				request.setAttribute("success", "Vehicle added successfully.");
				RequestDispatcher rd = request.getRequestDispatcher("jsp/rto/adminRtoHome.jsp");
				rd.forward(request, response);
			}
		} else if (row == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("");
			request.setAttribute("errmsg", data + " already exits.");
			rd.forward(request, response);
		}
	}
	
	private Registration getRegistration(HttpServletRequest request) {
		Registration registration = new Registration();
		registration.setName(request.getParameter("name"));
		registration.setAddress(request.getParameter("address"));
		registration.setContactNo(request.getParameter("contactNo"));
		registration.setEmailId(request.getParameter("emailId"));
		registration.setUsername(request.getParameter("username"));
		registration.setPassword(request.getParameter("password"));
		registration.setLevel(2); // this is user registration
		registration.setStatus("YES");
		registration.setDesignation(request.getParameter("designation"));
		return registration;
	}

	private Vehicle getVehicle(HttpServletRequest request) {
		Vehicle vehicle = new Vehicle();
		vehicle.setOwnerName(request.getParameter("ownerName"));
		vehicle.setRegNo(request.getParameter("regNo"));
		vehicle.setRegDate(request.getParameter("regDate"));
		vehicle.setDlNo(request.getParameter("dlNo"));
		vehicle.setAddress(request.getParameter("address"));
		vehicle.setCharssisNo(request.getParameter("charssisNo"));
		vehicle.setEngineNo(request.getParameter("engineNo"));
		vehicle.setModel(request.getParameter("model"));
		vehicle.setColor(request.getParameter("color"));
		vehicle.setStatus(request.getParameter("status"));
		vehicle.setComment(request.getParameter("comment"));
		return vehicle;
	}

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        VehicleDao vehicleDao = new VehicleDaoImpl();
        if (anchor.equals("addVehicle")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/rto/addVehicle.jsp");
            rd.forward(request, response);
        } else if(anchor.equals("viewVehicle")) {
        	List<Vehicle> vehicles = vehicleDao.viewVehicles();
            RequestDispatcher rd = request.getRequestDispatcher("jsp/rto/viewVehicle.jsp");
            request.setAttribute("vehicles", vehicles);
            rd.forward(request, response);
        } else if(anchor.equals("searchVehicle")) {
        	RequestDispatcher rd = request.getRequestDispatcher("jsp/employee/searchVehicle.jsp");
        	request.setAttribute("search", "search");
            rd.forward(request, response);
        } else if (anchor.equals("addEmployee")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/rto/addEmployee.jsp");
            rd.forward(request, response);
        } else if(anchor.equals("viewEmployee")) {
        	List<Registration> employees = vehicleDao.viewEmployees();
            RequestDispatcher rd = request.getRequestDispatcher("jsp/rto/viewEmployee.jsp");
            request.setAttribute("employees", employees);
            rd.forward(request, response);
        }
    } 
}


