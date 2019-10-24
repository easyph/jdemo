package com.stu.demo.controller;

import com.stu.demo.dao.model.User;
import com.stu.demo.dao.repository.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "用户api", description = "用户相关api")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "根据id查询用户信息", notes = "查询数据库中某个用户信息")
    @RequestMapping(value = "/userinfo/{id}", method = {RequestMethod.GET})
//    @ApiImplicitParam(name = "id", required = true, value = "用户ID", paramType = "path", dataType = "int")
    public String userInfo(@ApiParam(name="id", value = "用户id", required = true) @PathVariable("id") int id){
        User user = userMapper.selectByPrimaryKey(id);
        return user.getUsername();
    }


//    @RequestMapping(value = "/userinfo", method = { RequestMethod.POST})
//    @ApiOperation(value = "根据id查询用户信息", notes = "查询数据库中某个用户信息")
//    public String userInfo2(@ApiParam(name="id", value = "用户ID", required = true) @RequestParam("id") int id){
//
//        User user = userMapper.selectByPrimaryKey(id);
//        return user.getUsername();
//    }

    @ApiOperation(value = "根据id查询用户信息", notes = "查询数据库中某个用户信息")
    @RequestMapping(value = "/userinfo", method = { RequestMethod.POST})
    @ApiImplicitParam(name = "id", required = true, value = "用户ID", paramType = "path", dataType = "int")

    public String userInfo2(@RequestParam(value = "idd",required = true) int id){

        User user = userMapper.selectByPrimaryKey(id);
        return user.getUsername();
    }


    @ApiOperation(value = "新增用户")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, paramType = "body", dataType = "User")

    public String addUser(@RequestBody User user){
        return user.getUsername();
    }
}