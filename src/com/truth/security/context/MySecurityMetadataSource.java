package com.truth.security.context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import com.truth.security.model.PowerModel;
import com.truth.security.model.ResourceModel;
import com.truth.security.model.RoleModel;
import com.truth.security.service.PowerService;
import com.truth.security.service.ResourceService;
import com.truth.security.service.RoleService;



/**
 * 
 * @author liyx14
 *
 */
@Service("mySecurityMetadataSource")
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource{
 
	Logger log=Logger.getLogger(MySecurityMetadataSource.class);

	@Resource
	private RoleService roleService;
	
	@Resource
	private PowerService powerService;
	
	@Resource
	private ResourceService resourceService;
	
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}
	
	private void loadResourceDefine(){
		if(resourceMap == null){
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			//搜索全部role
			List<RoleModel> roles = roleService.getAllRoles();
			if(roles == null || roles.size() == 0){
				return;
			}
			//搜索全部power
			List<PowerModel> powers = powerService.getAllPowers();
			if(powers == null || powers.size() == 0){
				return;
			}
			//搜索全部resource
			List<ResourceModel> resources = resourceService.getAllResources();
			if(resources == null || resources.size() == 0){
				return;
			}
			//加载所有资源与权限的关系
			for (ResourceModel resourceModel : resources) {
				
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
				
				String resourceUrl = resourceModel.getResourceUrl();
				String resourceId = resourceModel.getId();
				for (PowerModel powerModel : powers) {
					//这里简单用contains方法,有瑕疵
					if(powerModel.getResourceIds().contains(resourceId)){
						String powerId = powerModel.getId();
						for (RoleModel roleModel : roles) {
							if(roleModel.getPowerIds().contains(powerId)){
								String roleType = roleModel.getRoleType();
								ConfigAttribute configAttribute = new SecurityConfig(roleType);
								boolean isAtrrExist = false;
								for (ConfigAttribute configAttr : configAttributes) {
									if(configAttr.equals(configAttribute)){
										isAtrrExist = true;
									}
								}
								if(!isAtrrExist){
									configAttributes.add(configAttribute);
								}
							}
						}
					}
				}
				resourceMap.put(resourceUrl, configAttributes);
			}			
			
		}
	}
	
	//返回所请求资源所需要的权限
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		if(resourceMap == null) {
			loadResourceDefine();
		}
		return resourceMap.get(requestUrl);
	}

}
