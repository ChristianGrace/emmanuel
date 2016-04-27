package com.truth.security.context;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.truth.security.model.UserSecruity;
import com.truth.security.model.Users;
import com.truth.security.service.UsersService;



/**
 * 
 * @author liyx14
 *
 */
@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService{
	
	Logger log=Logger.getLogger(MyUserDetailsService.class);

	@Resource
	private UsersService userService;
	
	//登录验证
	public UserDetails loadUserByUsername(String name)throws UsernameNotFoundException {
		
		Users users =userService.findbyUsername(name);
		Set<GrantedAuthority> grantedAuths=obtionGrantedAuthorities(users);
		
		boolean enables = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		UserSecruity userDetail = new UserSecruity(users.getId(),users.getLogname(), users.getPassword(), enables, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
		//User userdetail = new User(users.getName(), users.getPassword(), enables, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
		return userDetail;
	}
	//查找用户权限
	public Set<GrantedAuthority> obtionGrantedAuthorities(Users users){
		
		Set<GrantedAuthority> authSet=new HashSet<GrantedAuthority>();
		String[] roles=users.getRole_ids().split(",");
		for(String role:roles){
			authSet.add(new GrantedAuthorityImpl(role));
		}
		return authSet;
	}

}
