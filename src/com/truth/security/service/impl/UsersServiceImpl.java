package com.truth.security.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.truth.security.dao.UsersDao;
import com.truth.security.model.Users;
import com.truth.security.service.UsersService;

//@Repository("UsersService")
@Service("UsersService")
public class UsersServiceImpl implements UsersService {

	@Resource
	private UsersDao usersDao;
	
	@Override
	public Users findbyUsername(String name) {
		return usersDao.findbyUsername(name);
	}

}
