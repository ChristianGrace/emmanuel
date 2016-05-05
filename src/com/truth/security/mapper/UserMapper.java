package com.truth.security.mapper;


import java.util.List;

import com.truth.security.model.Users;

public interface UserMapper {
	
	public Users findbyUsername(String name);

	public List<Users> getAllUsers();
}
