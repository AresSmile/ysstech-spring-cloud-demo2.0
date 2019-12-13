package com.ysstech.demo.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("ticket")
public class Ticket {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private String startAddr;
	private String endAddr;
	private String type;
	private Integer number;

}
