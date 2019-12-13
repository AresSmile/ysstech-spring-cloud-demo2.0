package com.ysstech.demo.ticket.controller;

import java.util.List;
import java.util.Random;

import com.sun.xml.internal.ws.resources.HttpserverMessages;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@Value("${server.port}")
	private Integer port;
	

	/*
	 * @Author huangyuan
	 * @Description //测试feign调用 17:56
	 * @Date 17:56 2019/12/9
	 * @Param [ticketId]
	 * @returnType com.ysstech.demo.commons.web.util.JsonResult<java.util.List<com.ysstech.demo.commons.entity.Ticket>>
	 **/
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
	
	

	/*
	 * @Author huangyuan
	 * @Description //测试本服务请求 17:57
	 * @Date 17:57 2019/12/9
	 * @Param []
	 * @returnType java.util.List<com.ysstech.demo.commons.entity.Ticket>
	 **/
	@RequestMapping("/test/abc")
	public List<Ticket>  get() {
		
		List<Ticket> test = ticketService.getTest();
		return test;
		
	}


	/*
	 * @Author huangyuan
	 * @Description //测试热部署 18:00
	 * @Date 18:00 2019/12/9
	 * @Param []
	 * @returnType java.lang.String
	 **/
	@RequestMapping("/test/jrebel")
	public String  test() {

		return "jrebel";

	}


	/*
	 * @Author huangyuan
	 * @Description //测试sql 17:58
	 * @Date 17:58 2019/12/9
	 * @Param []
	 * @returnType java.util.List<com.ysstech.demo.commons.entity.Ticket>
	 **/
	@RequestMapping("/test/Sql")
	public List<Ticket>  testSql() {
		List<Ticket> list=ticketService.testSql();
		return list;

	}
	
	/*
	 * @Author huangyuan
	 * @Description //测试mybatis plus 16:26
	 * @Date 16:26 2019/12/6
	 * @Param [message]
	 * @returnType void
	 **/
	@RequestMapping("/test/Sql/plus")
	public void insert(HttpserverMessages message) {
		Integer row=ticketService.insert();
		log.info(row.toString());

	}
	/*
	 * @Author huangyuan
	 * @Description //测试mapper的sql 16:11
	 * @Date 16:11 2019/12/6
	 * @Param 
	 * @returnType 
	 **/
	@RequestMapping("/test/Sql/mapper")
	public void insertmapper() {
		Integer row=ticketService.insertmapper();
		log.info(row.toString());

	}


}
