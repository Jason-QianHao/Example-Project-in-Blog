package com.jason.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.jason.domain.User;
import com.jason.service.RedisService;
import com.jason.util.Constant;

/**
 * 设计到结构：
 * name1: user1
 * name2: user2
 * ...
 * "user": [user1, user2]
 * @author qianhao
 *
 */
@RestController
public class UserController {

	@Autowired
	private RedisService redisService;
	
	/**
	 * 添加一个用户信息到Redis
	 * @param user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/addUser")
	public String addUser(User user) {
		try {
			redisService.redisSetString(user.getName(), JSON.toJSONString(user));
			redisService.expire(user.getName(), 2*60l);
			List<User> list = (List<User>)redisService.getList(Constant.USERS);
			list.add(user);
			redisService.redisSetList(Constant.USERS, list);
			redisService.expire(Constant.USERS, 2*60l);
			System.out.println("user:" + user.getName());
			return "user:" + user.getName();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
	
	/**
	 * 根据name查询用户信息
	 * @param name
	 * @return
	 */
	@RequestMapping("/getUser")
	public String getUser(String name){
		try {
			String json = (String) redisService.redisGetString(name);
			return JSON.toJSONString(JSON.parseObject(json, User.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
	
	/**
	 * 查询当前有效用户信息列表
	 * @return
	 */
	@RequestMapping("/getUserList")
	public String getUserList() {
		try {
			return JSON.toJSONString(redisService.getList(Constant.USERS));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
	
	/**
	 * 根据用户名删除用户信息
	 * @param name
	 * @return
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(String name) {
		try {
			redisService.removeStringKey(name);
			return "Success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
	
	/**
	 * 删除有效用户列表
	 * @return
	 */
	@RequestMapping("/deleteList")
	public String deleteList() {
		try {
			redisService.removeStringKey(Constant.USERS);
			return "Success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
}
