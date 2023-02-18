package com.jason.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jason.dao.UserRepository;
import com.jason.domain.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 返回所有信息
	 * @return
	 */
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	/**
	 * 插入一个文档数据
	 * @param user
	 */
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	/**
	 * 根据用户id查询文档数据
	 * @param id
	 * @return
	 */
	public User getUserById(long id) {
		return userRepository.findById(id).orElse(new User());
	}
	
	
	/**
	 * 根据用户id删除文档数据
	 * @param id
	 */
	public void deleteUserById(long id) {
		userRepository.deleteById(id);
	}
	
	/**
	 * 更新用户文档数据
	 * @param user
	 */
	public void updateUser(User user) {
		userRepository.save(user);
	}
}
