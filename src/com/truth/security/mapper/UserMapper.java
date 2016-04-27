package com.truth.security.mapper;


import com.truth.security.model.Users;

public interface UserMapper {
	
	public Users findbyUsername(String name);
}
