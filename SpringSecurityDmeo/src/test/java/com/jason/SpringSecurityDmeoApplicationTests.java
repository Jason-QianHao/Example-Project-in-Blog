package com.jason;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.alibaba.fastjson.JSON;
import com.jason.dao.UserRepository;
import com.jason.domain.User;

@SpringBootTest
class SpringSecurityDmeoApplicationTests {

	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

    @Test
    public void addUser(){
    	User user = new User();
    	user.setUsername("jason");
    	user.setPassword(passwordEncoder.encode("123456"));
    	user.setAge(24);
    	userRepository.save(user);
    }

}
