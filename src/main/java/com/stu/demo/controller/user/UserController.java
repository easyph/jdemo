package com.stu.demo.controller.user;

import com.stu.demo.common.beans.params.UserInfoVO;
import com.stu.demo.dao.model.User;
import com.stu.demo.dao.repository.UserMapper;
import com.stu.demo.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Service;
import java.util.ArrayList;
import java.util.List;

@Api(value = "用户api", description = "用户相关api")
@RestController
@RequestMapping("/user")
@Scope("prototype")


public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;


    @ApiOperation(value = "id查询用户名字")
    @ApiImplicitParam(name = "id", required = true, value = "用户ID", paramType = "path", dataType = "int")
    @RequestMapping(value = "/username/{id}", method = {RequestMethod.GET})
    public String getUserNameByID(@PathVariable("id") int id){
        return userService.getUserNmae(id);
    }


    @ApiOperation(value = "id查询用户信息")
    @ApiImplicitParam(name = "id", required = true, value = "用户ID", paramType = "query", dataType = "int")
    @RequestMapping(value = "/userinfo", method = { RequestMethod.GET})
    public UserInfoVO userInfo2(@RequestParam(value = "id") int id){
        return userService.getUserInfo(id);
    }


    @ApiOperation(value = "新增用户")
    @ApiImplicitParam(name = "userInfo", value = "用户详细实体user", required = true, paramType = "body", dataType = "UserInfoVO")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int addUser(@RequestBody UserInfoVO userInfo){
        return userService.addUser(userInfo);
    }

    @ApiOperation(value = "更新用户信息")
    @ApiImplicitParam(name = "userInfo", value = "用户详细实体user", required = true, paramType = "body", dataType = "UserInfoVO")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public int updateUser(@RequestBody UserInfoVO userInfo){
        return userService.updateUserInfo(userInfo);
    }

    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "del", method = RequestMethod.GET)
    public int delUser(int id){

//        userMapper.deleteByPrimaryKey(1);
        return userService.delUser(id);
    }


}