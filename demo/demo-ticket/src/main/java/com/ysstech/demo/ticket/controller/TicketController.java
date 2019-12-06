package com.ysstech.demo.ticket.controller;

import java.util.List;
import java.util.Random;

import com.ysstech.demo.commons.entity.Ticket;
import com.ysstech.demo.commons.service.TicketService;
import com.ysstech.demo.commons.web.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/{ticketId}")
	JsonResult<List<Ticket>> getTicket(@PathVariable Integer ticketId) throws Exception {
		
		//模拟请求失败，降级处理
		log.info("server.port="+port+", orderId="+ticketId);
		
		if (Math.random()<0.6) {
			int t = new Random().nextInt(5000);
			log.info("延迟 - "+t);
			Thread.sleep(t);
		}
		
		List<Ticket> tickets = ticketService.getTicket(ticketId);
		return JsonResult.ok(tickets).msg("port = "+port);
	}
	
	
	@RequestMapping("/test/abc")
	public List<Ticket>  get() {
		
		List<Ticket> test = ticketService.getTest();
		return test;
		
	}

}
