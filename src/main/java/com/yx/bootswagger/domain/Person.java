package com.yx.bootswagger.domain;

import lombok.Data;

@Data
public class Person {

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
