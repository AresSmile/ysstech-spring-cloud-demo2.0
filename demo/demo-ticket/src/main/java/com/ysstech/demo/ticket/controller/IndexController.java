package com.ysstech.demo.ticket.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: huangyuan
 * @Date: 2019/12/6 15:46
 * @Description:
 */
@Controller
public class IndexController {

    /**
     * 业务需求: 通过url实现页面跳转功能
     * /page/user
     * /page/ticket
     *
     * 共性:
     * 	1.请求路径的后半部分不同
     * 	2.请求路径与跳转页面相同
     *
     *思考: 能否编辑一个方法实现页面的通用跳转??
     *
     *RestFul风格  必会内容
     *	1.url中的参数必须使用"/"分割
     *  2.服务端获取数据时.必须使用"{}"包裹参数
     *  3.使用@PathVariable注解实现数据转化
     *
     *  如果接收参数名称与url变量名称不一致.
     *  则需要使用value属性标识
     *  @PathVariable(value = "moduleName") String abc
     */

   /*
    * @Author huangyuan
    * @Description //测试前端页面用的 14:23
    * @Date 14:23 2019/12/9
    * @Param [moduleName]
    * @returnType java.lang.String
    **/
    @RequestMapping("/page/{moduleName}")
    public String itemAdd(@PathVariable String moduleName) {

        return moduleName;
    }

}
