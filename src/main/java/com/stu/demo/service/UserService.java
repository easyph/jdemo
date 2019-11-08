package com.stu.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.stu.demo.common.beans.params.UserInfoVO;
import com.stu.demo.dao.model.User;
import com.stu.demo.dao.repository.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

@Service("userService")
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public String getUserNmae(int userId){
        User user = userMapper.selectByPrimaryKey(userId);
        return user.getUserName();
    }

    public List<UserInfoVO> getUserInfo(int userId){
        User user = userMapper.selectByPrimaryKey(userId);
        List<UserInfoVO> userInfo = new ArrayList<>();
//        userInfo.add(user);
        BeanUtils.copyProperties(user, userInfo);
        return userInfo;

    }

    public int updateUserInfo(UserInfoVO userInfo){

        System.out.println(JSONObject.toJSONString(userInfo));

        User user = new User();
        user.setId(userInfo.getID());
        user.setRealName("大师兄孙悟空");
        user.setUserName("我是大师兄");
        BeanUtils.copyProperties(userInfo, user);
        return userMapper.updateByPrimaryKeySelective(user);

    }

    public int addUser(UserInfoVO userInfo){
        System.out.println(JSONObject.toJSONString(userInfo));
        User user = new User();
        BeanUtils.copyProperties(userInfo, user);
        user.setIsDel((byte) 0);
        System.out.println(JSONObject.toJSONString(user));
        return userMapper.insert(user);
    }

    public int delUser(int userId){

        User user = new User();
        user.setId(userId);
        user.setIsDel((byte) 1);

        return userMapper.updateByPrimaryKeySelective(user);
    }
}
