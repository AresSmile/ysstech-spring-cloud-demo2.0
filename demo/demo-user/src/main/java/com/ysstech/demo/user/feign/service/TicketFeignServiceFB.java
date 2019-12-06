package com.ysstech.demo.user.feign.service;

import java.util.List;

import com.ysstech.demo.commons.entity.Ticket;
import com.ysstech.demo.commons.web.util.JsonResult;
import org.springframework.stereotype.Component;


@Component
public class TicketFeignServiceFB implements TicketFeignService {


	@Override
	public JsonResult<List<Ticket>> getTicket(Integer ticketId) {
		return JsonResult.err("无法获取票信息");
	}


}
