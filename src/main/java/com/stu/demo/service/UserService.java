package com.stu.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stu.demo.common.beans.params.UserInfoVO;
import com.stu.demo.dao.model.User;
import com.stu.demo.dao.repository.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;
import java.util.List;

@Service("userService")
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public String getUserNmae(int userId){
        User user = userMapper.selectByPrimaryKey(userId);

//        1 输出字符串时间格式
        String time;
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        time = date.format(new Date());
        System.out.println("1：" +time);


//        2 时间字符串转时间戳
        try {
            long timeObj = date.parse("2010-01-01 12:00:00").getTime();
            System.out.println("2: " + timeObj);
        }catch (ParseException e){
            e.printStackTrace();
        }
//        System.out.println(new Date());
        return user.getUserName();
    }

    public UserInfoVO getUserInfo(int userId){

        User user = userMapper.selectByPrimaryKey(userId);
        UserInfoVO userInfo = new UserInfoVO();
        BeanUtils.copyProperties(user, userInfo);

        System.out.println(JSON.toJSONString(user));
        System.out.println(JSON.toJSONString(userInfo));
        return userInfo;

    }

    public int updateUserInfo(UserInfoVO userInfo){

        User user = new User();
        BeanUtils.copyProperties(userInfo, user);

        System.out.println(JSONObject.toJSONString(userInfo));
        System.out.println(JSONObject.toJSONString(user));
        return userMapper.updateByPrimaryKeySelective(user);

    }

    public int addUser(UserInfoVO userInfo){

        User user = new User();
        BeanUtils.copyProperties(userInfo, user);
        user.setIsDel((byte) 0);
        user.setCreateTime(new Date());
        user.setLastModifyTime(new Date());

        System.out.println(JSONObject.toJSONString(userInfo));
        System.out.println(JSONObject.toJSONString(user));
        return userMapper.insertSelective(user);
    }

    public int delUser(int userId){

        User user = new User();
        user.setId(userId);
        user.setIsDel((byte) 1);

        return userMapper.updateByPrimaryKeySelective(user);
    }
}
