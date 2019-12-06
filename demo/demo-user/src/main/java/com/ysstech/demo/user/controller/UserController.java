package com.ysstech.demo.user.controller;

import com.ysstech.demo.commons.entity.User;
import com.ysstech.demo.commons.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/demo/")
	@ResponseBody
	public User getUser() {
		log.info("查询用户 - userId - "+7);
		User user = userService.getUser(7);
		return user;
	}

}
