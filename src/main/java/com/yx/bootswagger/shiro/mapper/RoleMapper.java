package com.yx.bootswagger.shiro.mapper;

import java.util.List;

import com.yx.bootswagger.shiro.domain.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    /**
     * 根据用户ID查询角色
     */
    List<Role> queryRolesByUserId(Integer userid);
}