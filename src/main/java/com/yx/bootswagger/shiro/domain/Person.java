package com.yx.bootswagger.shiro.domain;

import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

@Data
public class Person extends BaseRowModel {

	private Integer id;
	private String name;
	private String address;
	private Integer sex;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(Integer id, String name, String address, Integer sex) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.sex = sex;
	}


	
}
