package com.yx.bootswagger.utils;

import java.util.List;

import com.yx.bootswagger.domain.User;
import lombok.Data;

@Data
public class ActiverUser {
//	用户
	private User user;
//
	private List<String> roles;
//	权限的集合
	private List<String> permissions;

		

}
