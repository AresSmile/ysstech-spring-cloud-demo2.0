package com.ysstech.demo.commons.service;

import com.ysstech.demo.commons.entity.Ticket;

import java.util.List;



public interface TicketService {
	
	List<Ticket> getTicket(Integer id);

	List<Ticket> getTest();

}
