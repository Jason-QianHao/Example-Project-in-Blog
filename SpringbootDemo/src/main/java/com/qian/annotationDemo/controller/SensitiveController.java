package com.qian.annotationDemo.controller;

import com.alibaba.fastjson.JSON;
import com.qian.annotationDemo.FieldSensitive;
import com.qian.annotationDemo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/3/4 15:03
 * @Description:
 */

@RestController
public class SensitiveController {

    /**
     * 测试注解是否生效
     * @return
     */
    @RequestMapping("/annotation")
    public String test(){
        User user = new User("1", "千小虎", "12388889999");
        return JSON.toJSONString(user);
    }
}
