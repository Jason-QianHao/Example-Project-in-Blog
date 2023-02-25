package com.qian.controller;

import com.qian.model.User;
import com.qian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/2/25 19:27
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     * @param user
     * @return
     */
    @RequestMapping("/user")
    public String addUser(User user){
        return userService.addUser(user);
    }

    /**
     * 根据userId查询用户信息
     * @param userId
     * @return
     */
    @RequestMapping("/userid")
    public String queryUser(long userId){
        return userService.queryUserById(userId).toString();
    }
}
