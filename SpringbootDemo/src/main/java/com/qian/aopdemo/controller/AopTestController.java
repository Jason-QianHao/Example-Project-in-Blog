package com.qian.aopdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/2/5
 * @Description:
 */
@RestController
public class AopTestController {

    @RequestMapping("/aop")
    public String aop(){
        try {
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "test";
    }
}
