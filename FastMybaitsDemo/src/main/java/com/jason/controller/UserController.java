package com.jason.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.gitee.fastmybatis.core.PageInfo;
import com.gitee.fastmybatis.core.query.Query;
import com.jason.domain.User;
import com.jason.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 查询所有记录
	 * @return
	 */
	@RequestMapping("/getAll")
	public String getAll() {
		List<User> list = userService.list(new Query());
		return JSON.toJSONString(list);
	}
	
	/**
	 * 分页查询所有记录
	 * @param pageindex
	 * @param pagesize
	 * @return
	 */
	@RequestMapping("/pageQuery")
	public String pageQuery(int pageindex, int pagesize) {
		Query page = new Query().page(pageindex, pagesize);
		PageInfo<User> info = userService.page(page);
		return JSON.toJSONString(info.getList());
	}
	
	/**
	 * 插入一个用户记录
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(User user) {
		try {
			userService.save(user);
			return "save user ok";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "save user failed";
		}
	}
}
