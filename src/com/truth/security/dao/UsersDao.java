package com.truth.security.dao;

import java.util.List;

import com.truth.security.model.Users;


public interface UsersDao {
	
	public Users findbyUsername(String name);

	public List<Users> getAllUsers();
}
