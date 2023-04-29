package com.jason.controller;

import com.jason.mapper.UserMapper;
import com.jason.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/4/29 17:57
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/addUser")
    public String addUser(){
        try {
            for (int i = 0; i < 10; i++) {
                User testName = new User("test_name" + i, 0, i+10);
                userMapper.insert(testName);
            }
            return "success";
        }catch (Exception e){
            System.out.println("adduser error:" + e);
            return "error:" + e.getMessage();
        }
    }

    @RequestMapping("user")
    public String user(String uid){
        try {
            List<User> userList = userMapper.selectList(null);
            return userList.toString();
        }catch (Exception e){
            System.out.println("query user error:" + e);
        }
        return null;
    }
}
