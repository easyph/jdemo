package com.stu.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Api(value = "首页1", description = "首页相关的api", tags = "首页")
@RequestMapping(value = "index1")
public class Index1Controller {

    @Value("${config.site.siteName}")
    private String siteName;

    @Value("${config.site.version}")
    private float version;

    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    @ApiOperation(value = "首页信息", notes = "首页内容")
    public String index(){
        return "site name:" + siteName + ", site version:" + version;
    }




}
