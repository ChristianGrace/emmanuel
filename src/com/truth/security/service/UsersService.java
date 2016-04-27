package com.truth.security.service;

import com.truth.security.model.Users;

public interface UsersService {
	Users findbyUsername(String name);
}
