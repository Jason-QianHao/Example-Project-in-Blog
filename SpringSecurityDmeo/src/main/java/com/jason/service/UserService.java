package com.jason.service;

import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jason.domain.User;
import com.jason.domain.UserDetailsImpl;
import com.jason.util.JwtUtil;

@Service
public class UserService {

	@Autowired
    private AuthenticationManager authenticationManager;
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public String login(User user) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //使用id生成token
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticate.getPrincipal();
        String userId = String.valueOf(loginUser.getUser().getId());
        String jwt = JwtUtil.createJWT(userId);
        //把token响应给前端
        return jwt;
	}
}
