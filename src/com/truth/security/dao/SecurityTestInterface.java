package com.truth.security.dao;

import java.util.List;


import com.truth.security.model.URLResource;
import com.truth.security.model.Users;

public interface SecurityTestInterface {

	boolean getinput();

	boolean geoutput();
	//@RolesAllowed("ROLE_ADMIN")//拥有ROLE_ADMIN权限的用户才可进入此方法
	boolean addreport_admin();
	//@RolesAllowed("ROLE_ADMIN")
	boolean deletereport_admin();
	
	//@RolesAllowed("ROLE_USER")
	void user_login();

	List<URLResource> findResource();

}
