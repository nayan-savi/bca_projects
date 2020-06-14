package com.system.bugtracker.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.system.bugtracker.dao.EmployeeDao;
import com.system.bugtracker.dao.EmployeeDaoImpl;
import com.system.bugtracker.dao.TicketDao;
import com.system.bugtracker.dao.TicketDaoImpl;
import com.system.bugtracker.model.Employee;
import com.system.bugtracker.model.Ticket;

@WebServlet(name = "TicketController")
public class TicketController extends HttpServlet {

	private final String UPLOAD_DIRECTORY = "F:/uploads";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String anchor = request.getParameter("anchor");
		TicketDao ticketDao = new TicketDaoImpl();
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		String ticketId = request.getParameter("ticketId");
		int level = (int) session.getAttribute("designation");
		String byName = (String) session.getAttribute("username");
		String id = request.getParameter("id");
		String data = "";
		int row = -1;
		if (anchor.equals("addTicket") || anchor.equals("updateTicket")) {
			if (ServletFileUpload.isMultipartContent(request)) {
				try {
					List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
					Ticket ticket = new Ticket();
					FileItem upload = null;
					String name = "";
					for (FileItem item : multiparts) {
						if (!item.isFormField()) {
							name = new File(item.getName()).getName();
							upload = item;
							ticket.setFileName(name);
						} else {
							if (item.getFieldName().equals("title")) {
								ticket.setTitle(item.getString());
							} else if (item.getFieldName().equals("assignTo")) {
								ticket.setAssignTo(item.getString());
							} else if (item.getFieldName().equals("lastDate")) {
								ticket.setLastDate(item.getString());
							} else if (item.getFieldName().equals("rootCause")) {
								ticket.setRootCause(item.getString());
							} else if (item.getFieldName().equals("status")) {
								ticket.setStatus(item.getString());
							} else if (item.getFieldName().equals("comment")) {
								ticket.setComment(item.getString());
							}
						}
					}
					request.setAttribute("success", "File Uploaded Successfully");
					ticket.setAssignFrom((String) session.getAttribute("username"));
					if(anchor.equals("addTicket")) {
						row = ticketDao.saveTicket(ticket);
						data = "add";
					} else {
						ticket.setTicketId(Integer.parseInt(id));
						row = ticketDao.updateTicket(ticket);
						data = "update";
					}
					if(row == 1 && name != "") {
						upload.write(new File(UPLOAD_DIRECTORY + File.separator + name));
					}
					
					
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			} else {
				request.setAttribute("error", "Sorry this Servlet only handles file upload request");
			}
			//request.getRequestDispatcher("jsp/employee/employeeHome.jsp").forward(request, response);
		} else if (anchor.equals("modifyTicket")) {
			List<Employee> employees = employeeDao.viewEmployees(true);
			Ticket ticket = ticketDao.getTicketById(ticketId);
			request.setAttribute("employees", employees);
			request.setAttribute("ticket", ticket);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/employee/modifyTicket.jsp");
			rd.forward(request, response);
		} else if (anchor.equalsIgnoreCase("cancelTicket")) {
			response.sendRedirect(request.getContextPath() + "/viewTicket?anchor=viewTicket");
		} else if(anchor.equalsIgnoreCase("searchTicket")) {
			List<Ticket> tickets = null;
			String status = request.getParameter("status");
			if(level == 3) {
				tickets = ticketDao.viewTickets(byName, status);
			} else {
				tickets = ticketDao.viewTickets("", status);
			}
            RequestDispatcher rd = request.getRequestDispatcher("jsp/employee/viewTicket.jsp");
            request.setAttribute("tickets", tickets);
            if(!tickets.isEmpty()) {
	            request.setAttribute("notFound", null);
            } else {
            	request.setAttribute("notFound", "");
            }
            rd.forward(request, response);
		}
		
		if (row > 0) {
			if ("update".equals(data) || "add".equals(data)) {
				response.sendRedirect(request.getContextPath() + "/viewTicket?anchor=viewTicket");
			} 
				 
		} else if (row == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("");
			request.setAttribute("errmsg", data + " already exits.");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String anchor = request.getParameter("anchor");
		HttpSession session = request.getSession();
		TicketDao ticketDao = new TicketDaoImpl();
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		String byName = (String) session.getAttribute("username");
		int level = (int) session.getAttribute("designation");
		if (anchor.equalsIgnoreCase("addTicket")) {
			List<Employee> employees = employeeDao.viewEmployees(true);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/employee/addTicket.jsp");
			request.setAttribute("employees", employees);
			rd.forward(request, response);
		} else if(anchor.equals("viewTicket")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/employee/viewTicket.jsp");
    		request.setAttribute("notFound", null);
            rd.forward(request, response);
        }
	}

	
}
