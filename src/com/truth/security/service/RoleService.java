package com.truth.security.service;

import java.util.List;

import com.truth.security.model.RoleModel;

public interface RoleService {
	
	public RoleModel getRoleModelByRoleType(String roleType);

	public List<RoleModel> getAllRoles();
}
