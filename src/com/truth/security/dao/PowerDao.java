package com.truth.security.dao;

import java.util.List;

import com.truth.security.model.PowerModel;

public interface PowerDao {
	
	public PowerModel getPowerModelById(String id);

	public List<PowerModel> getAllPowers();

}
