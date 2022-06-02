package com.jason.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jason.domain.User;
import com.jason.mapper.UserMapping;

@RestController
public class UserController {

	@Autowired
	private UserMapping userMapping;
	
	/**
	 * 查询所有记录
	 * @return
	 */
	@RequestMapping("/getAll")
	public String getAll() {
		List<User> list = userMapping.selectList(new QueryWrapper<User>());
		return JSON.toJSONString(list);
	}
	
	/**
	 * 分页查询
	 * @param pageindex
	 * @param pagesize
	 * @return
	 */
	@RequestMapping("page")
	public String page(int pageindex, int pagesize) {
		Page<User> page = userMapping.selectPage(new Page<User>(pageindex, pagesize), new QueryWrapper<User>());
		System.out.println(JSON.toJSON(page));
		return JSON.toJSONString(page.getRecords());
	}
	
	/**
	 * 新增一个用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(User user) {
		try {
			int insert = userMapping.insert(user);
			return String.valueOf(insert);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "addUser failed";
		}
	}
}
