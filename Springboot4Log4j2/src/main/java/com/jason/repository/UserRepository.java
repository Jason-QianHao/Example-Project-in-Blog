package com.jason.repository;

import com.jason.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
    /**
     * 返回用户信息
     * @param name
     * @return
     */
    public User getUserByName(String name){
        logger.info("查询{}用户信息", name);
        return new User(name, 28);
    }

}