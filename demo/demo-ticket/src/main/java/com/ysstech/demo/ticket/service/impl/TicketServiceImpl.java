package com.ysstech.demo.ticket.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ysstech.demo.commons.entity.Ticket;
import com.ysstech.demo.commons.service.TicketService;
import com.ysstech.demo.ticket.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketMapper ticketMapper;

	@Override
	public List<Ticket> getTicket(Integer id) {
		//模拟数据库的数据
		ArrayList<Ticket> list = new ArrayList<Ticket>();
		list.add(new Ticket(1, "深圳", "北京","成人票",1));
		list.add(new Ticket(1, "深圳", "北京","成人票",1));
		list.add(new Ticket(1, "深圳", "北京","成人票",1));
		list.add(new Ticket(1, "深圳", "北京","成人票",1));
		list.add(new Ticket(1, "深圳", "北京","成人票",1));
		list.add(new Ticket(1, "深圳", "北京","成人票",1));
		return list;
	}

	@Override
	public List<Ticket> getTest() {
		
		List<Ticket> selectList = ticketMapper.selectList(null);
		for (Ticket ticket : selectList) {
			System.out.println(ticket);

		}
		return selectList;
	}

}
