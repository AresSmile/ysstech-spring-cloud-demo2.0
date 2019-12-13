package com.ysstech.demo.ticket.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysstech.demo.commons.entity.Ticket;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TicketMapper extends BaseMapper<Ticket>{
    @Select("select * from ticket")
    List<Ticket> testSql();


    Integer insertMapper();
}
