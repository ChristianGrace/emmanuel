package com.truth.security.dao.impl;


import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.truth.security.dao.UsersDao;
import com.truth.security.mapper.UserMapper;
import com.truth.security.model.Users;

@Repository("UsersDao")
//@Component : 该注解使用所有层
public class UsersDaoImpl implements UsersDao {
	Logger log=Logger.getLogger(UsersDaoImpl.class);
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public Users findbyUsername(String name) {
		
		final Users users = userMapper.findbyUsername(name);

		return users;
	}

	@Override
	public List<Users> getAllUsers() {
		return userMapper.getAllUsers();
	}

}
