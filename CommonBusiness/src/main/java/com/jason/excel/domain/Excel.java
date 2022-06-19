package com.jason.excel.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Excel {

	private String name;
	private int age;
	private double score;
	private boolean isPass;
	private Date examDate;
}
