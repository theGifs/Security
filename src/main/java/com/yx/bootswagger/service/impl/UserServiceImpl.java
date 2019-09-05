package com.yx.bootswagger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yx.bootswagger.domain.User;
import com.yx.bootswagger.mapper.UserMapper;
import com.yx.bootswagger.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryUserByUserName(String userName) {
		return userMapper.queryUserByUserName(userName);
	}

}
