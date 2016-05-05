package com.truth.security.service;

import java.util.List;

import com.truth.security.model.Users;

public interface UsersService {
	
	Users findbyUsername(String name);
	
	public List<Users> getAllUsers();
}
