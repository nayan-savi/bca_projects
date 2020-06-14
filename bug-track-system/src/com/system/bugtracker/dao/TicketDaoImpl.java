package com.system.bugtracker.dao;

import java.sql.ResultSet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.system.bugtracker.model.Ticket;
import com.system.bugtracker.util.ConnectionDb;

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
            String query = "INSERT INTO TICKET (TITLE,ASSIGNTO,FILEPATH,FILENAME,ASSIGNFROM,LASTDATE,ROOTCAUSE,STATUS,COMMENT) VALUES ('"
            		+ticket.getTitle()+ "','" +ticket.getAssignTo()+ "','"             		
            		+ticket.getFilePath()+ "','" +ticket.getFileName()+ "','" 
            		+ticket.getAssignFrom()+ "','" +ticket.getLastDate()+ "','" 
            		+ticket.getRootCause()+ "','" +ticket.getStatus()+ "','" +ticket.getComment()+"')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}

	@Override
    public List<Ticket> viewTickets(String byName) {
        List<Ticket> tickets = new ArrayList<>();
        try {
            String query = "SELECT * FROM TICKET";
            if(byName != "") {
            	query += " WHERE ASSIGNTO ='"+byName+"'";
            }
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setTicketId(Integer.parseInt(rs.getString("TICKETID")));
				ticket.setTitle(rs.getString("TITLE"));
				ticket.setAssignTo(rs.getString("ASSIGNTO"));
				//ticket.setFilePath(rs.getString("FILEPATH"));
				ticket.setFileName(rs.getString("FILENAME"));
				ticket.setAssignFrom(rs.getString("ASSIGNFROM"));
				ticket.setLastDate(rs.getString("LASTDATE"));
				ticket.setRootCause(rs.getString("ROOTCAUSE"));
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
            	ticket.setTicketId(Integer.parseInt(rs.getString("TICKETID")));
				ticket.setTitle(rs.getString("TITLE"));
				ticket.setAssignTo(rs.getString("ASSIGNTO"));
				ticket.setFilePath(rs.getString("FILEPATH"));
				ticket.setFileName(rs.getString("FILENAME"));
				ticket.setAssignFrom(rs.getString("ASSIGNFROM"));
				ticket.setLastDate(rs.getString("LASTDATE"));
				ticket.setRootCause(rs.getString("ROOTCAUSE"));
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
			String query = "UPDATE TICKET SET ROOTCAUSE = '" + ticket.getRootCause() + "', STATUS = '" + ticket.getStatus()
					+ "', COMMENT = '" + ticket.getComment() + "', FILENAME = '" + ticket.getFileName() 
					+ "', ASSIGNTO = '" + ticket.getAssignTo() 
					+ "' WHERE TICKETID = '" + ticket.getTicketId() + "'";
			return stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

        return 0;
    }

}


