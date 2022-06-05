package com.jason.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.jason.entity.UserEntity;

@Mapper
public interface UserMapping {

	@Select("select * from user")
	public List<UserEntity> getAll();
}
