package com.truth.security.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.truth.security.dao.ResourceDao;
import com.truth.security.mapper.ResourceMapper;
import com.truth.security.model.ResourceModel;

@Repository("ResourceDao")
public class ResourceDaoImpl implements ResourceDao {
	
	Logger log = Logger.getLogger(ResourceDaoImpl.class);
	
	@Resource
	private ResourceMapper resourceMapper;
	
	@Override
	public ResourceModel getResourceModelById(String id) {
		final ResourceModel resource = new ResourceModel();
		return resource;
	}

	@Override
	public List<ResourceModel> getAllResources() {
		return resourceMapper.getAllResources();
	}

}
