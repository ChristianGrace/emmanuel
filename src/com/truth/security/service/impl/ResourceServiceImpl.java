package com.truth.security.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.truth.security.dao.ResourceDao;
import com.truth.security.model.ResourceModel;
import com.truth.security.service.ResourceService;

@Repository("ResourceService")
public class ResourceServiceImpl implements ResourceService {

	@Resource
	private ResourceDao resourceDao;
	
	@Override
	public ResourceModel getResourceModelById(String id) {
		return resourceDao.getResourceModelById(id);
	}

	@Override
	public List<ResourceModel> getAllResources() {
		return resourceDao.getAllResources();
	}

}
