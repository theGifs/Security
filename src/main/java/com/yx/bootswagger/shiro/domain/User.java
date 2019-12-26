package com.yx.bootswagger.shiro.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

//用户
@Data
public class User {
    @ExcelProperty(value = "用户ID",index = 0)
    private Integer userid;
    @ExcelProperty(value = "姓名",index = 1)
    private String username;
    @ExcelProperty(value = "密码",index = 2)
    private String userpwd;
    @ExcelProperty(value = "性别",index = 3)
    private String sex;
    @ExcelProperty(value = "地址",index = 4)
    private String address;



}