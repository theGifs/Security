package com.yx.bootswagger.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yx.bootswagger.domain.Role;
import com.yx.bootswagger.mapper.RoleMapper;
import com.yx.bootswagger.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<String> queryRolesByUserId(Integer userId) {
		List<Role> list = this.roleMapper.queryRolesByUserId(userId);
		List<String> data=new ArrayList<>();
		for (Role role : list) {
			data.add(role.getRolename());
		}
		return data;
	}

}
