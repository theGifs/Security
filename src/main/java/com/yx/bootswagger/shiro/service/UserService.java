package com.yx.bootswagger.shiro.service;

import com.yx.bootswagger.shiro.domain.User;

public interface UserService {

	/**
	 * 根据用户名查询用户
	 */
	User queryUserByUserName(String userName);
}
