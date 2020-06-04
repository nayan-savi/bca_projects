package com.club.cricket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.club.cricket.dao.TicketDao;
import com.club.cricket.dao.TicketDaoImpl;
import com.club.cricket.model.Book;
import com.club.cricket.model.Ticket;

@WebServlet(name = "TicketController")
public class TicketController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String anchor = request.getParameter("anchor");
		String ticketId = request.getParameter("ticketId");
		String data = "";
		int row = -1;
		TicketDao ticketDao = new TicketDaoImpl();
		if (anchor.equals("addTicket")) {
			Ticket ticket = getTicket(request);
			row = ticketDao.saveTicket(ticket);
			data = "Ticket";
		} else if(anchor.equals("modifyTicket")) {
            Ticket ticket = ticketDao.getTicketById(ticketId);
              request.setAttribute("ticket", ticket);
              RequestDispatcher rd = request.getRequestDispatcher("jsp/club/modifyTicket.jsp");
              rd.forward(request, response);
        } else if(anchor.equals("updateTicket")) {
            Ticket ticket = getTicket(request);
            ticket.setTicketId(Integer.parseInt(request.getParameter("ticketId")));
            row = ticketDao.updateTicket(ticket);
            data = "update";
        } else if (anchor.equalsIgnoreCase("cancelTicket")) {
            response.sendRedirect(request.getContextPath()+"/viewTicket?anchor=viewTicket");
        } else if(anchor.equals("viewBooked")) {
        	String date = request.getParameter("eventDate");
            List<Book> tickets = ticketDao.viewBookedTickets(date);
            RequestDispatcher rd = request.getRequestDispatcher("jsp/club/viewBooked.jsp");
            if(tickets.isEmpty()) {
            	request.setAttribute("notFound", null);
            } else {
            	request.setAttribute("books", tickets);
            }
            rd.forward(request, response);
        }

		if (row > 0) {
		    if("update".equals(data)) {
                response.sendRedirect(request.getContextPath()+"/viewTicket?anchor=viewTicket");
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("jsp/club/adminClubHome.jsp");
                request.setAttribute("success", "Event added Successfully.");
                rd.forward(request, response);
            }
		} else if (row == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("");
			request.setAttribute("errmsg", data + " already exits.");
			rd.forward(request, response);
		}
	}

	private Ticket getTicket(HttpServletRequest request) {
		Ticket ticket = new Ticket();
		ticket.setEventName(request.getParameter("eventName"));
		ticket.setEventType(request.getParameter("eventType"));
		ticket.setEventDate(request.getParameter("eventDate"));
		ticket.setEventTime(request.getParameter("eventTime"));
		ticket.setEventPlace(request.getParameter("eventPlace"));
		ticket.setPrice(Double.parseDouble(request.getParameter("price")));
		ticket.setAvailable(Integer.parseInt(request.getParameter("available")));
		ticket.setStatus(request.getParameter("status"));
		ticket.setComment(request.getParameter("comment"));
		return ticket;
	}

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        TicketDao ticketDao = new TicketDaoImpl();
        if (anchor.equals("addTicket")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/club/addTicket.jsp");
            rd.forward(request, response);
        } else if(anchor.equals("viewTicket")) {
            List<Ticket> tickets = ticketDao.viewTickets();
            RequestDispatcher rd = request.getRequestDispatcher("jsp/club/viewTicket.jsp");
            request.setAttribute("tickets", tickets);
            rd.forward(request, response);
        } else if(anchor.equals("viewBooked")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/club/viewBooked.jsp");
            request.setAttribute("notFound", "");
            rd.forward(request, response);
        }
    }
}