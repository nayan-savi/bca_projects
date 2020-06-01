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

import com.voilation.traffic.dao.VehicleDao;
import com.voilation.traffic.dao.VehicleDaoImpl;
import com.voilation.traffic.model.Complaint;
import com.voilation.traffic.model.Vehicle;

@WebServlet(name = "VehicleController")
public class VehicleController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String anchor = request.getParameter("anchor");
		String vehicleId = request.getParameter("id");
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
        }

		if (row > 0) {
			if(data.equals("update")) {
				response.sendRedirect(request.getContextPath()+"/viewVehicle?anchor=viewVehicle");
			} else {
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
        }
    } 
}


