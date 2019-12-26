package com.yx.bootswagger.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yx.bootswagger.shiro.domain.User;
import com.yx.bootswagger.shiro.mapper.UserMapper;
import com.yx.bootswagger.shiro.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryUserByUserName(String userName) {
		return userMapper.queryUserByUserName(userName);
	}

}
