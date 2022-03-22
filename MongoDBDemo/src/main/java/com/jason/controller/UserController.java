package com.jason.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.jason.domain.User;
import com.jason.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 返回所有用户信息
	 * @return
	 */
	@RequestMapping("/getAll")
	public String getAll() {
		try {
			return JSON.toJSONString(userService.getAll());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
	
	/**
	 * 插入一个用户
	 * @return
	 */
	@RequestMapping("/addUser/{id}")
	public String addUser(@PathVariable("id") long id) {
		User user = new User(1l, "jason", 24);
		User user2 = new User(2l, "dreamboat", 23);
		try {
			if(id == 1l)
				userService.addUser(user);
			else 
				userService.addUser(user2);
			return "Success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
	
	@RequestMapping("/getUser")
	public String getUser() {
		try {
			return JSON.toJSONString(userService.getUserById(1l));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
	
	/**
	 * 删除一个用户
	 * @return
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser() {
		try {
			userService.deleteUserById(1l);
			return "Success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
	
	/**
	 * 更新一个用户信息
	 * @return
	 */
	@RequestMapping("/updateUser")
	public String updateUser() {
		User user = new User(1l, "ironman", 44);
		try {
			userService.updateUser(user);
			return "Success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "Failed";
		}
	}
}
