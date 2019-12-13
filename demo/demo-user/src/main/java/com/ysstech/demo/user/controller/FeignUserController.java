package com.ysstech.demo.user.controller;

import java.util.List;

import com.ysstech.demo.commons.entity.Ticket;
import com.ysstech.demo.commons.web.util.JsonResult;
import com.ysstech.demo.user.feign.service.TicketFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FeignUserController {
	
	@Autowired
	private TicketFeignService ticketService;
	
	


		/*
		 * @Author huangyuan
		 * @Description //通过微服务调用ticket-service服务,做了降级处理TicketFeignServiceFB以及熔断 ，和负载均衡,18:01
		 * @Date 18:01 2019/12/9
		 * @Param [ticketId]
		 * @returnType com.ysstech.demo.commons.web.util.JsonResult<java.util.List<com.ysstech.demo.commons.entity.Ticket>>
		 **/
		@GetMapping("/ticket-service/{ticketId}")
		public JsonResult<List<Ticket>> getTicket(@PathVariable Integer ticketId) {
			return ticketService.getTicket(ticketId);
			
		}

}
