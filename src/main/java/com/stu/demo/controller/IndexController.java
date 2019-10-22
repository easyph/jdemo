package com.stu.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "index")
@Api(value = "UserController相关的api", description = "用户中心")
public class IndexController {

    @Value("${com.test.name}")
    private String name;

    @Value("${com.test.age}")
    private Integer age;

    @RequestMapping(value = "/userinfo/{id}", method = {RequestMethod.GET})
    @ApiOperation(value = "根据id查询学生信息", notes = "查询数据库中某个的学生信息")
    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")
    public String userInfo1(@ApiParam(name="id", value = "用户id", required = true) @PathVariable("id") int id){
        return "name:" + name + ",age:" + age + ",id:" + id;
    }


    @RequestMapping(value = "/userinfo", method = { RequestMethod.POST})
    @ApiOperation(value = "根据id查询学生信息", notes = "查询数据库中某个的学生信息")
    public String userInfo2(@ApiParam(name="id", value = "用户id", required = true) @RequestParam("id") int id){
        return "name:" + name + ",age:" + age + ",id:" + id;
    }

}
