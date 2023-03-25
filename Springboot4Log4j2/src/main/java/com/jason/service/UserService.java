package com.jason.service;

import com.jason.model.User;
import com.jason.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询用户信息
     * @param name
     * @return
     */
    public User queryUser(String name){
        logger.info("查询{}用户信息", name);
        return userRepository.getUserByName(name);
    }
}