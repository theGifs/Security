package com.yx.bootswagger.service;

import com.yx.bootswagger.domain.User;

public interface UserService {

	/**
	 * 根据用户名查询用户
	 */
	User queryUserByUserName(String userName);
}
