package com.yx.bootswagger.shiro.mapper;

import com.yx.bootswagger.shiro.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**
     * 根据登陆名查询用户
     */
    User queryUserByUserName(String username);
    
}