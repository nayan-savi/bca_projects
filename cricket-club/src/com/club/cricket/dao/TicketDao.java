package com.club.cricket.dao;

import java.util.List;

import com.club.cricket.model.Book;
import com.club.cricket.model.Ticket;

public interface TicketDao {

	int saveTicket(Ticket ticket);

    List<Ticket> viewTickets();

    Ticket getTicketById(String parameter);

    int updateTicket(Ticket ticket);
    
    List<Ticket> getAvailableActiveTicket();

    List<String> getActiveTicketNames(String username);

	List<Book> viewBookedTickets(String date);
}

