package com.ysstech.demo.user.controller;

import java.util.List;

import com.ysstech.demo.commons.entity.Ticket;
import com.ysstech.demo.commons.web.util.JsonResult;
import com.ysstech.demo.user.feign.service.TicketFeignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户买票Controller" ,tags = {"用户买票接口"})
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
		@ApiOperation(value = "根据ticketId查询车票信息",notes = "根据ticketId查询车票信息")
		@ApiImplicitParam(name = "ticketId",value = "车票id",dataType = "Integer")
		@ApiResponse(code = 400,message = "没票了")
		@GetMapping("/ticket-service/{ticketId}")
		public JsonResult<List<Ticket>> getTicket(@PathVariable Integer ticketId) {
			return ticketService.getTicket(ticketId);
			
		}

}
