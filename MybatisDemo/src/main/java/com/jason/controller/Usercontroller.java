package com.jason.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.jason.entity.User;
import com.jason.entity.UserExample;
import com.jason.mapper.UserMapper;

@RestController
public class Usercontroller {

	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(User user) {
		try {
			userMapper.insert(user);
			return "Success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
	
	/**
	 * 返回所有用户数据
	 * @return
	 */
	@RequestMapping("/getAll")
	public String getAll() {
		try {
			return JSON.toJSONString(userMapper.selectByExample(new UserExample()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
	
	/**
	 * 更加用户名查找用户信息
	 * @param username
	 * @return
	 */
	@RequestMapping("/getUser")
	public String getUser(String username) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(username);
		try {
			return JSON.toJSONString(userMapper.selectByExample(userExample));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
	
	/**
	 * 删除用户信息
	 * @param username
	 * @return
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(String username) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(username);
		try {
			userMapper.deleteByExample(userExample);
			return "Success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
	
	/**
	 * 更新用户信息
	 * @param username
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateUser")
	public String updateUser(String username, int age) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(username);
		try {
			List<User> users = userMapper.selectByExample(userExample);
			User user = users.get(0);
			user.setAge(age);
			userMapper.updateByExample(user, userExample);
			return "Success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
}
