package com.qian.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/2/25 19:14
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    /**用户id*/
    private long userId;

    /**用户名*/
    private String name;
}
