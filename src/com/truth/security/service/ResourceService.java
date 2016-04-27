package com.truth.security.service;

import java.util.List;

import com.truth.security.model.ResourceModel;

public interface ResourceService {
	
	public ResourceModel getResourceModelById(String id);

	public List<ResourceModel> getAllResources();
}
