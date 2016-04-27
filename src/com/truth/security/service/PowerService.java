package com.truth.security.service;

import java.util.List;

import com.truth.security.model.PowerModel;

public interface PowerService {
	
	public PowerModel getPowerModelById(String id);

	public List<PowerModel> getAllPowers();
}
