package com.ysstech.demo.user.service.impl;

import java.util.List;

import com.ysstech.demo.commons.entity.User;
import com.ysstech.demo.commons.service.UserService;
import com.ysstech.demo.commons.web.util.JsonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

@Service
public class UserServiceImpl implements UserService {
	
	@Value("${test.user-service.users}")
	private String userJson;
	
	@Override
	public User getUser(Integer id) {
		List<User> list = 
		 JsonUtil.from(userJson,
		 new TypeReference<List<User>>() {});
		
		for (User user : list) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		
		return new User(id, "username"+id, "password"+id);
	}

}
