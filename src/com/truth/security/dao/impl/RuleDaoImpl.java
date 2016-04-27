package com.truth.security.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.truth.security.dao.RuleDao;
import com.truth.security.mapper.RoleMapper;
import com.truth.security.model.RoleModel;


@Repository("RuleDao")
public class RuleDaoImpl implements RuleDao {
	
	Logger log = Logger.getLogger(RuleDaoImpl.class);
	
	@Resource
	private RoleMapper roleMapper;
	
	@Override
	public RoleModel getRoleModelByRoleType(String roleType) {
		final RoleModel role = new RoleModel();
		return role;
	}

	@Override
	public List<RoleModel>  getAllRoles() {
		return roleMapper.getAllRoles();
	}

}
