package com.green.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.user.dto.UserDto;

@Mapper
public interface UserMapper {

	void insertUser(UserDto userDto);

	List<UserDto> getUserList();

	void deleteUser(UserDto userDto);

	UserDto getUser(UserDto userDto);

	void updateUser(UserDto userDto);

	UserDto getIdDupCheck(UserDto userDto);

	





}