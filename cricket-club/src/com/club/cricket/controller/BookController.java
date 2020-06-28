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

import com.club.cricket.dao.BookDao;
import com.club.cricket.dao.BookDaoImpl;
import com.club.cricket.dao.TicketDao;
import com.club.cricket.dao.TicketDaoImpl;
import com.club.cricket.model.Book;
import com.club.cricket.model.Ticket;

@WebServlet(name = "BookController")
public class BookController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String anchor = request.getParameter("anchor");
		String bookId = request.getParameter("id");
		HttpSession session = request.getSession(true);
		String data = "";
		int row = -1;
		BookDao bookDao = new BookDaoImpl();
		if (anchor.equals("addBook")) {
			Book book = getBook(request);
			double price = Double.parseDouble(request.getParameter("price"));
			int bookings = Integer.parseInt(request.getParameter("booking"));
			book.setPrice(price * bookings);
			book.setUsername((String)session.getAttribute("username"));
			row = bookDao.saveBook(book);
			data = "Book";
		} else if(anchor.equals("modifyBook")) {
            Book book = bookDao.getBookById(bookId);
              request.setAttribute("book", book);
              RequestDispatcher rd = request.getRequestDispatcher("jsp/customer/modifyBook.jsp");
              rd.forward(request, response);
        } else if(anchor.equals("updateBook")) {
            Book book = getBook(request);
            book.setBookId(Integer.parseInt(request.getParameter("bookId")));
            row = bookDao.updateBook(book);
            data = "update";
        } else if (anchor.equalsIgnoreCase("cancelBook")) {
            response.sendRedirect(request.getContextPath()+"/viewBook?anchor=viewBook");
        }

		if (row > 0) {
		    if("update".equals(data)) {
                response.sendRedirect(request.getContextPath()+"/viewBook?anchor=viewBook");
            } else {
            	RequestDispatcher rd = request.getRequestDispatcher("jsp/customer/customerHome.jsp");
            	request.setAttribute("success", "Ticket booked successfully.");
            	rd.forward(request, response);
            }
		} else if (row == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("");
			request.setAttribute("errmsg", data + " already exits.");
			rd.forward(request, response);
		}
	}

	private Book getBook(HttpServletRequest request) {
		Book book = new Book();
		book.setEventName(request.getParameter("eventName"));
		book.setEventDate(request.getParameter("eventDate"));
		book.setEventTime(request.getParameter("eventTime"));
		book.setEventPlace(request.getParameter("eventPlace"));
		book.setPrice(Double.parseDouble(request.getParameter("price")));
		book.setBooking(Integer.parseInt(request.getParameter("booking")));
		return book;
	}

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        BookDao bookDao = new BookDaoImpl();
        HttpSession session = request.getSession(true);
        TicketDao ticketDao = new TicketDaoImpl();
        if (anchor.equals("addBook")) {
        	List<Ticket> tickets = ticketDao.getAvailableActiveTicket();
            RequestDispatcher rd = request.getRequestDispatcher("jsp/customer/addBook.jsp");
            request.setAttribute("tickets", tickets);
            rd.forward(request, response);
        } else if(anchor.equals("viewBook")) {
            List<Book> books = bookDao.viewBooks((String)session.getAttribute("username"));
            RequestDispatcher rd = request.getRequestDispatcher("jsp/customer/viewBook.jsp");
            request.setAttribute("books", books);
            rd.forward(request, response);
        }
    }
}
