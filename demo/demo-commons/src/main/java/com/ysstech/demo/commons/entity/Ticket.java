package com.ysstech.demo.commons.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
	private Integer id;
	private String startAddr;
	private String endAddr;
	private String type;
	private Integer number;

}
