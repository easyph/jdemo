package com.stu.demo.controller.user;

import com.stu.demo.dao.TestVO;
import com.stu.demo.dao.model.User;
import com.stu.demo.dao.repository.UserMapper;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "用户api", description = "用户相关api")
@RestController
@RequestMapping("/user")
@Scope("prototype")


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
        List<User> userList = new ArrayList<>();
        userList.add(user);
        return userList;
    }


    @ApiOperation(value = "新增用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, paramType = "body", dataType = "User")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
//        User user = userMapper.insert(user);
        return user.getUsername();
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public boolean updateUser(){
        User user = new User();
        user.setId(1);
        user.setRealname("大大师兄");
        user.setUsername("大大da师兄111");
        userMapper.updateByPrimaryKeySelective(user);
        return false;
    }
    @RequestMapping(value = "del", method = RequestMethod.GET)
    public boolean delUser(){

        userMapper.deleteByPrimaryKey(1);
        return false;
    }


}