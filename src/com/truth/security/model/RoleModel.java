package com.truth.security.model;



public class RoleModel {
	
	private String id;
	
	private String roleName;
	
	private String roleType;
	
	private String powerIds;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public String getPowerIds() {
		return powerIds;
	}
	public void setPowerIds(String powerIds) {
		this.powerIds = powerIds;
	}
	
}
