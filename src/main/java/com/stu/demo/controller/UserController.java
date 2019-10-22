package com.stu.demo.controller;

import com.stu.demo.dao.model.User;
import com.stu.demo.dao.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id) {
//        return "aaa";
         User user = userMapper.selectByPrimaryKey(1);
         return user.getUsername();
    }

}