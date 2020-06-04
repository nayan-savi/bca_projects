package com.club.cricket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.club.cricket.model.Book;
import com.club.cricket.util.ConnectionDb;

public class BookDaoImpl implements BookDao {

	private Statement stmt;

    public BookDaoImpl() {
        try {
            stmt = ConnectionDb.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public int saveBook(Book book) {
		try {
            String query = "INSERT INTO BOOK (PRICE, EVENTNAME,EVENTDATE,EVENTTIME,EVENTPLACE, USERNAME, BOOKING) VALUES ('"+book.getPrice()+ "','" +book.getEventName()+ "','" +book.getEventDate()+ "','" 
            				+book.getEventTime()+ "','"
            				+book.getEventPlace()+ "','"
            						+book.getUsername()+ "','"
            				+book.getBooking()+"')";
            String update = "UPDATE TICKET SET AVAILABLE = AVAILABLE-"+book.getBooking()+", BOOKED = BOOKED + 1 WHERE EVENTNAME = '"+book.getEventName()+"' ";
            stmt.addBatch(query);
            stmt.addBatch(update);
            int[] rows = stmt.executeBatch();
            return rows[0] * rows[1];
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}

	@Override
    public List<Book> viewBooks(String username) {
        List<Book> books = new ArrayList<>();
        try {
            String query = "SELECT * FROM BOOK WHERE USERNAME = '"+username+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("BOOKID"));
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

    @Override
    public Book getBookById(String id) {
        Book book = new Book();
        try {
            String query = "SELECT * FROM Book WHERE BookID = ('"+id+"')";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
				book.setEventName(rs.getString("EVENTNAME"));
				book.setEventDate(rs.getString("EVENTDATE"));
				book.setEventTime(rs.getString("EVENTTIME"));
				book.setEventPlace(rs.getString("EVENTPLACE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public int updateBook(Book book) {
        try {
			/*
			 * String query = "UPDATE Book SET MODEL = '"+book.getModel()+"', COLOR = '"
			 * +book.getColor()+"', COMMENT = '"+book.getComment()
			 * +"', ADDRESS= '"+book.getAddress()+"' where bookId = '"+book.getVehicleId()+
			 * "'";
			 */
            return stmt.executeUpdate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}

