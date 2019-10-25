package com.stu.demo.controller.user;

import com.stu.demo.dao.TestVO;
import com.stu.demo.dao.model.User;
import com.stu.demo.dao.repository.UserMapper;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "用户api", description = "用户相关api")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;



    @ApiOperation(value = "id查询用户信息")
    @ApiImplicitParam(name = "id", required = true, value = "用户ID", paramType = "path", dataType = "int")
    @RequestMapping(value = "/userinfo/{id}", method = {RequestMethod.GET})
    public String userInfo(@PathVariable("id") int id){
        User user = userMapper.selectByPrimaryKey(id);
        return user.getUsername();
    }


    @ApiOperation(value = "id查询用户信息")
    @ApiImplicitParam(name = "id", required = true, value = "用户ID", paramType = "query", dataType = "int")
    @RequestMapping(value = "/userinfo", method = { RequestMethod.GET})
    public List<User> userInfo2(@RequestParam(value = "id") int id){
        User user = userMapper.selectByPrimaryKey(id);
        List<User> userArrayList = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        userArrayList.add(user);
        return userArrayList;
    }


    @ApiOperation(value = "新增用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, paramType = "body", dataType = "User")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
//        User user = userMapper.insert(user);
        return user.getUsername();
    }


}