package com.kiran.blog.services;

import java.util.List;

import com.kiran.blog.entities.User;
import com.kiran.blog.payloads.UserDto;

public interface UserService {
	//as we donot use entity for service
	UserDto createUser(UserDto user);//here we pass the entity refrence for storage
	UserDto updateUser(UserDto user,Integer userId);
	List<UserDto>getAllUsers();
	void deleteUser(Integer UserId);
	UserDto getUserById(Integer userId);
}
