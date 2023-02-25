package com.qian.service.impl;

import com.qian.model.User;
import com.qian.service.UserService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/2/25 19:23
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 模拟数据库
     */
    private static final Map<Long, User> DATABASES = new ConcurrentHashMap();

    /**
     * 初始化数据
     */
    static {
        DATABASES.put(1L, new User(1L, "user1"));
        DATABASES.put(2L, new User(2L, "user2"));
        DATABASES.put(3L, new User(3L, "user3"));
    }

    @CachePut(value = "user", key = "#user.userId")
    @Override
    public String addUser(User user) {
        DATABASES.put(user.getUserId(), user);
        return user.toString();
    }

    @Cacheable(value = "user", key = "#userId")
    @Override
    public User queryUserById(long userId) {
        // 我们假设从数据库读取
        System.out.println("这是从数据库读取的，不是从缓存读取的");
        return DATABASES.get(userId);
    }

    @Override
    public String deleteUserById(long userId) {
        return null;
    }
}
