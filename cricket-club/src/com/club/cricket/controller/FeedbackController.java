package com.club.cricket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.club.cricket.dao.FeedbackDao;
import com.club.cricket.dao.FeedbackDaoImpl;
import com.club.cricket.dao.TicketDao;
import com.club.cricket.dao.TicketDaoImpl;
import com.club.cricket.model.Feedback;
import com.club.cricket.model.Ticket;

@WebServlet(name = "FeedbackController")
public class FeedbackController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String anchor = request.getParameter("anchor");
		HttpSession session = request.getSession(true);
		String data = "";
		int row = -1;
		FeedbackDao feedbackDao = new FeedbackDaoImpl();
		if (anchor.equals("addFeedback")) {
			Feedback feedback = new Feedback();
			feedback.setEventName(request.getParameter("eventName"));
			feedback.setFeedbackBy((String)session.getAttribute("username"));
			feedback.setEmailId((String)session.getAttribute("emailId"));
			feedback.setRating(Integer.parseInt(request.getParameter("rating")));
			feedback.setComments(request.getParameter("comments"));
			
			row = feedbackDao.saveFeedback(feedback);
			data = "Feedback";
		} 

		if (row > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/customer/customerHome.jsp");
			request.setAttribute("success", "Feedback submitted.");
            rd.forward(request, response);
            
		} else if (row == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/customer/customerHome.jsp");
			request.setAttribute("errmsg", "Feedback already submitted");
			//response.sendRedirect(request.getContextPath()+"/addFeedback?anchor=addFeedback");
			rd.forward(request, response);
		}
	}

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        TicketDao ticketDao = new TicketDaoImpl();
        HttpSession session = request.getSession(true);
        FeedbackDao feedbackDao = new FeedbackDaoImpl();
        if (anchor.equals("addFeedback")) {
        	List<String> tickets = ticketDao.getActiveTicketNames((String)session.getAttribute("username"));
            RequestDispatcher rd = request.getRequestDispatcher("jsp/customer/addFeedback.jsp");
            request.setAttribute("tickets", tickets);
            rd.forward(request, response);
        } else if(anchor.equals("viewFeedback")) {
            List<Feedback> feedbacks = feedbackDao.viewFeedbacks();
            RequestDispatcher rd = request.getRequestDispatcher("jsp/club/viewFeedback.jsp");
            request.setAttribute("feedbacks", feedbacks);
            rd.forward(request, response);
        }
    }
}