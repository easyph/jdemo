package com.stu.demo.controller.index;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "首页", description = "首页相关的api")
@RequestMapping(value = "index")
public class IndexController {

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
