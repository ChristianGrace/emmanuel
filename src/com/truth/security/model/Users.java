package com.truth.security.model;

public class Users {
	private String id;
	private String logname;
	private String password;
	private String role_ids;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogname() {
		return logname;
	}
	public void setLogname(String logname) {
		this.logname = logname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole_ids() {
		return role_ids;
	}
	public void setRole_ids(String role_ids) {
		this.role_ids = role_ids;
	}
	
}
