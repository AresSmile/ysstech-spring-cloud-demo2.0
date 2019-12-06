package com.ysstech.demo.commons.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//setAndGet
@AllArgsConstructor//有参
@NoArgsConstructor//无参
public class User {
	private Integer id;
	private String username;
	private String password;

}
