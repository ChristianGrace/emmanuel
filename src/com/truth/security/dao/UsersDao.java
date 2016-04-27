package com.truth.security.dao;

import com.truth.security.model.Users;


public interface UsersDao {
	public Users findbyUsername(String name);
}
