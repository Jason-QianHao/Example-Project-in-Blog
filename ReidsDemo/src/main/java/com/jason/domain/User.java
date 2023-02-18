package com.jason.domain;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
