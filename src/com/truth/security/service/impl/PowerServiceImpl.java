package com.truth.security.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.truth.security.dao.PowerDao;
import com.truth.security.model.PowerModel;
import com.truth.security.service.PowerService;

@Repository("PowerService")
public class PowerServiceImpl implements PowerService {

	@Resource
	private PowerDao powerDao;
	
	@Override
	public PowerModel getPowerModelById(String id) {
		return powerDao.getPowerModelById(id);
	}

	@Override
	public List<PowerModel> getAllPowers() {
		return powerDao.getAllPowers();
	}

}
