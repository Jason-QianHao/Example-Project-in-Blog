package com.jason.controller;

import com.jason.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final Logger digest = LoggerFactory.getLogger("DIGEST");

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String getUser(String name) {
        logger.info("UserController.class 收到{}用户请求", name);
        try {
            String res = userService.queryUser(name).toString();
            digest.info("请求{}用户信息: {}", name, res);
            return res;
        } catch (Exception e) {
            logger.info("请求{}用户信息错误", name, e);
            return StringUtils.EMPTY;
        }
    }
}