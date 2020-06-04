package com.club.cricket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.club.cricket.model.Book;
import com.club.cricket.model.Ticket;
import com.club.cricket.util.ConnectionDb;

public class TicketDaoImpl implements TicketDao {

	private Statement stmt;

    public TicketDaoImpl() {
        try {
            stmt = ConnectionDb.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public int saveTicket(Ticket ticket) {
		try {
            String query = "INSERT INTO TICKET (TICKETID,EVENTNAME,EVENTTYPE,EVENTDATE,EVENTTIME,EVENTPLACE,PRICE,AVAILABLE,STATUS,COMMENT) VALUES ('"
            				+ticket.getTicketId()+ "','" 
            				+ticket.getEventName()+ "','" 
            				+ticket.getEventType()+ "','" 
            				+ticket.getEventDate()+ "','" 
            				+ticket.getEventTime()+ "','" 
            				+ticket.getEventPlace()+ "','" 
            				+ticket.getPrice()+ "','" 
            				+ticket.getAvailable()+ "','" +ticket.getStatus()+ "','" +ticket.getComment()+"')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}

	@Override
    public List<Ticket> viewTickets() {
        List<Ticket> tickets = new ArrayList<>();
        try {
            String query = "SELECT * FROM TICKET";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setTicketId(rs.getInt("TICKETID"));
                ticket.setEventName(rs.getString("EVENTNAME"));
				ticket.setEventType(rs.getString("EVENTTYPE"));
				ticket.setEventDate(rs.getString("EVENTDATE"));
				ticket.setEventTime(rs.getString("EVENTTIME"));
				ticket.setEventPlace(rs.getString("EVENTPLACE"));
				ticket.setPrice(rs.getDouble("PRICE"));
				ticket.setAvailable(rs.getInt("AVAILABLE"));
				ticket.setBooked(rs.getInt("BOOKED"));
				ticket.setStatus(rs.getString("STATUS"));
				ticket.setComment(rs.getString("COMMENT"));
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    @Override
    public Ticket getTicketById(String id) {
        Ticket ticket = new Ticket();
        try {
            String query = "SELECT * FROM Ticket WHERE TicketID = ('"+id+"')";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	ticket.setTicketId(rs.getInt("TICKETID"));
            	ticket.setEventName(rs.getString("EVENTNAME"));
            	ticket.setEventType(rs.getString("EVENTTYPE"));
            	ticket.setEventDate(rs.getString("EVENTDATE"));
            	ticket.setEventTime(rs.getString("EVENTTIME"));
            	ticket.setEventPlace(rs.getString("EVENTPLACE"));
            	ticket.setPrice(rs.getDouble("PRICE"));
            	ticket.setAvailable(rs.getInt("AVAILABLE"));
            	ticket.setStatus(rs.getString("STATUS"));
            	ticket.setComment(rs.getString("COMMENT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticket;
    }

    @Override
    public int updateTicket(Ticket ticket) {
        try {
			  String query = "UPDATE TICKET SET EVENTNAME = '"+ticket.getEventName()
			  +"', EVENTTYPE = '"+ticket.getEventType()
			  +"', EVENTDATE = '"+ticket.getEventDate()
			  +"', EVENTPLACE = '"+ticket.getEventPlace()
			  +"', PRICE = '"+ticket.getPrice()
			  +"', AVAILABLE = '"+ticket.getAvailable()
			  +"', COMMENT = '"+ticket.getComment()
			  +"', EVENTTIME= '"+ticket.getEventTime()+"' where TICKETID = '"+ticket.getTicketId()+"'";
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public List<Ticket> getAvailableActiveTicket() {
        List<Ticket> tickets = new ArrayList<>();
        try {
            String query = "SELECT * FROM TICKET WHERE STATUS = 'Active' AND AVAILABLE > 0 ";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setTicketId(rs.getInt("TICKETID"));
                ticket.setEventName(rs.getString("EVENTNAME"));
				ticket.setEventType(rs.getString("EVENTTYPE"));
				ticket.setEventDate(rs.getString("EVENTDATE"));
				ticket.setEventTime(rs.getString("EVENTTIME"));
				ticket.setEventPlace(rs.getString("EVENTPLACE"));
				ticket.setPrice(rs.getDouble("PRICE"));
				ticket.setAvailable(rs.getInt("AVAILABLE"));
				ticket.setBooked(rs.getInt("BOOKED"));
				ticket.setStatus(rs.getString("STATUS"));
				ticket.setComment(rs.getString("COMMENT"));
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

	@Override
	public List<String> getActiveTicketNames(String username) {
		List<String> tickets = new ArrayList<>();
        try {
            String query = "SELECT DISTINCT EVENTNAME FROM BOOK WHERE USERNAME = '"+username+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                tickets.add(rs.getString("EVENTNAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
	}

	@Override
	public List<Book> viewBookedTickets(String date) {
		List<Book> books = new ArrayList<>();
        try {
            String query = "SELECT * FROM BOOK";
            if(date != "" && date != null) {
            	query += " WHERE EVENTDATE = '"+date+"'";
            }
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("BOOKID"));
                book.setUsername(rs.getString("USERNAME"));
				book.setEventName(rs.getString("EVENTNAME"));
				book.setEventDate(rs.getString("EVENTDATE"));
				book.setEventTime(rs.getString("EVENTTIME"));
				book.setEventPlace(rs.getString("EVENTPLACE"));
				book.setPrice(rs.getDouble("PRICE"));
				book.setBooking(rs.getInt("BOOKING"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
	}

}


