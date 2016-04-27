package com.truth.security.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.truth.security.dao.RuleDao;
import com.truth.security.model.RoleModel;
import com.truth.security.service.RoleService;

/**
 * 
 * @author liyx14
 *
 */
@Repository("RoleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RuleDao ruleDao;
	
	
	@Override
	public RoleModel getRoleModelByRoleType(String roleType) {
		
		return ruleDao.getRoleModelByRoleType(roleType);
	}


	@Override
	public List<RoleModel>  getAllRoles() {
		
		return ruleDao.getAllRoles();
	}

}
