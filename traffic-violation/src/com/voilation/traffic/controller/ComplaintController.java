package com.voilation.traffic.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voilation.traffic.dao.ComplaintDao;
import com.voilation.traffic.dao.ComplaintDaoImpl;
import com.voilation.traffic.model.Complaint;

@WebServlet(name = "ComplaintController")
public class ComplaintController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String anchor = request.getParameter("anchor");
		String complaintId = request.getParameter("id");
		String data = "";
		int row = -1;
		ComplaintDao complaintDao = new ComplaintDaoImpl();
		if (anchor.equals("addComplaint")) {
			Complaint complaint = getComplaint(request);
			row = complaintDao.saveComplaint(complaint);
			data = "Complaint";
		} else if (anchor.equals("modifyComplaint")) {
			Complaint complaint = complaintDao.getComplaintById(complaintId);
            request.setAttribute("complaint", complaint);
            RequestDispatcher rd = request.getRequestDispatcher("jsp/employee/modifyComplaint.jsp");
            rd.forward(request, response);
		} else if (anchor.equals("updateComplaint")) {
			Complaint complaint = getComplaint(request);
			complaint.setComplaintId(Integer.parseInt(request.getParameter("complaintId")));
			row = complaintDao.updateComplaint(complaint);
            data = "update";
		} else if (anchor.equalsIgnoreCase("cancelComplaint")) {
            response.sendRedirect(request.getContextPath()+"/viewComplaint?anchor=viewComplaint");
        } 
		
		if (row > 0) {
			if("update".equals(data)) {
	            response.sendRedirect(request.getContextPath()+"/viewComplaint?anchor=viewComplaint");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("jsp/employee/employeeHome.jsp");
				rd.forward(request, response);
			}
		} else if (row == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("");
			request.setAttribute("errmsg", data + " already exits.");
			rd.forward(request, response);
		}
	}

	private Complaint getComplaint(HttpServletRequest request) {
		Complaint complaint = new Complaint();
		complaint.setRegNo(request.getParameter("regNo"));
		complaint.setPaymentType(request.getParameter("paymentType"));
		complaint.setPaymentDate(request.getParameter("paymentDate").toString());
		complaint.setFee(Double.parseDouble(request.getParameter("fee")));
		complaint.setReason(request.getParameter("reason"));
		complaint.setStatus(request.getParameter("status"));
		complaint.setComment(request.getParameter("comment"));
		return complaint;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String anchor = request.getParameter("anchor");
		ComplaintDao complaintDao = new ComplaintDaoImpl();
		if (anchor.equals("addComplaint")) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/employee/addComplaint.jsp");
			rd.forward(request, response);
		} else if(anchor.equals("viewComplaint")) {
			List<Complaint> complaints = complaintDao.viewComplaints();
			RequestDispatcher rd = request.getRequestDispatcher("jsp/employee/viewComplaint.jsp");
			request.setAttribute("complaints", complaints);
			rd.forward(request, response);
		} else if (anchor.equals("paidComplaint")) {
			List<Complaint> complaints = complaintDao.getPaidComplaints();
			RequestDispatcher rd = request.getRequestDispatcher("jsp/rto/paidComplaint.jsp");
			request.setAttribute("complaints", complaints);
			rd.forward(request, response);
		}
	}
	
	
}



