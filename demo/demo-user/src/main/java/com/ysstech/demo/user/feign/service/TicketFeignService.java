package com.ysstech.demo.user.feign.service;

import java.util.List;

import com.ysstech.demo.commons.entity.Ticket;
import com.ysstech.demo.commons.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="ticket-service",fallback = TicketFeignServiceFB.class)
public interface TicketFeignService {
	
	@GetMapping("/{ticketId}")
	JsonResult<List<Ticket>> getTicket(@PathVariable Integer ticketId);


}
