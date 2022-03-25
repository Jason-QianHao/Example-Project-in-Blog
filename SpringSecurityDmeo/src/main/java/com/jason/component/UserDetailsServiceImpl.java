package com.jason.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jason.dao.UserRepository;
import com.jason.domain.User;
import com.jason.domain.UserDetailsImpl;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new RuntimeException("用户名或密码错误");
		}
		return new UserDetailsImpl(user);
	}

}
