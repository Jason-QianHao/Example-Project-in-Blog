package com.jason.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jason.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/4/29 17:54
 * @Description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
