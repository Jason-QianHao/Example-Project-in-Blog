package com.jason.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String username;
	private String password;
	private int age;
}
