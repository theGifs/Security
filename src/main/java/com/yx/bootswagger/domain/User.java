package com.yx.bootswagger.domain;

import lombok.Data;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;

//用户
@Data
public class User {
    private Integer userid;

    private String username;

    private String userpwd;

    private String sex;

    private String address;



}