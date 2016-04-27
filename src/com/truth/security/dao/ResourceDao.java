package com.truth.security.dao;

import java.util.List;

import com.truth.security.model.ResourceModel;

public interface ResourceDao {
	
	public ResourceModel getResourceModelById(String id);

	public List<ResourceModel> getAllResources();
}
