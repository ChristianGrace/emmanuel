package com.truth.security.context;

import java.util.Collection;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;


/**
 * 
 * @author liyx14
 *
 */
@Service("myAccessDecisionManager")
public class MyAccessDecisionManager implements AccessDecisionManager{
	
	Logger log=Logger.getLogger(MyAccessDecisionManager.class);
	
	@Override
	public void decide(Authentication authentication, Object object,Collection<ConfigAttribute> configAttributes) throws AccessDeniedException,InsufficientAuthenticationException {
	 	
		if(configAttributes == null){
	 		
            return;
        }
	
		Iterator<ConfigAttribute> ite=configAttributes.iterator();
		while(ite.hasNext()){
			ConfigAttribute ca=ite.next();
			String needRole=ca.getAttribute();
			for(GrantedAuthority ga:authentication.getAuthorities()){
				if(needRole.equals(ga.getAuthority())){
					return;
				}
			}
		}
		throw new AccessDeniedException("no right");
	}

	@Override
	public boolean supports(ConfigAttribute arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
