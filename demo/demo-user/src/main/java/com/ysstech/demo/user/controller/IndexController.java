package com.ysstech.demo.user.controller;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: huangyuan
 * @Date: 2019/12/6 15:46
 * @Description:
 */
@Api(value = "通用页面跳转Controller",tags = "通用页面跳转")
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
    * @Description //TODO 14:23
    * @Date 14:23 2019/12/9
    * @Param [moduleName]
    * @returnType java.lang.String
    **/
   @ApiOperation(value = "请求路径和页面相同，根据页面对应路径请求",notes = "请求路径和页面相同，根据页面对应路径请求")
    @RequestMapping("/page/{moduleName}")
    public String toPage(@PathVariable String moduleName) {

        return moduleName;
    }

}
