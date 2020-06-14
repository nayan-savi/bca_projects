package com.system.bugtracker.dao;

import java.util.List;

import com.system.bugtracker.model.Ticket;

public interface TicketDao {
	int saveTicket(Ticket ticket);

    List<Ticket> viewTickets(String byName);

    Ticket getTicketById(String parameter);

    int updateTicket(Ticket ticket);
}
