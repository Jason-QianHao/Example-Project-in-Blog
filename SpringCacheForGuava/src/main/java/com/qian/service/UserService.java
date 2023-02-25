package com.qian.service;

import com.qian.model.User;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/2/25 19:19
 * @Description:
 */
public interface UserService {

    /**
     * 新增用户
     * @param user
     * @return
     */
    String addUser(User user);

    /**
     * 根据uid查询用户
     * @param userId
     * @return
     */
    User queryUserById(long userId);

    /**
     * 根据uid删除用户
     * @param userId
     * @return
     */
    String deleteUserById(long userId);
}
