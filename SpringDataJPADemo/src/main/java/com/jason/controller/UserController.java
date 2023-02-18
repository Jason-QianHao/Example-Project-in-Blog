package com.jason.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.jason.dao.UserRepository;
import com.jason.entity.User;

@RestController
@Transactional
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 添加一个用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(User user) {
		try {
			userRepository.save(user);
			return "Success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
	
	/**
	 * 查询数据库所有信息
	 * @return
	 */
	@RequestMapping("/getAll")
	public String getAll() {
		try {
			return JSON.toJSONString(userRepository.findAll());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
	
	@RequestMapping("/getUser")
	public String getUser(String username) {
		try {
			return JSON.toJSONString(userRepository.findByUsername(username));
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
	 * 
	 * 特别注意，删除操作需要添加@Transactional，开启事务
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(String username) {
		try {
			userRepository.deleteByUsername(username);
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
	 * @param age
	 * @return
	 */
	@RequestMapping("/updateUser")
	public String updateUser(String username, int age) {
		try {
			User findByUsername = userRepository.findByUsername(username);
			findByUsername.setAge(age);
			userRepository.save(findByUsername);
			return "Success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
	
}
