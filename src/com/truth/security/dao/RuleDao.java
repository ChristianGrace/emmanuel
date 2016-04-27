package com.truth.security.dao;

import java.util.List;

import com.truth.security.model.RoleModel;

public interface RuleDao {
	public RoleModel getRoleModelByRoleType(String roleType);

	public List<RoleModel>  getAllRoles();
}
