package com.truth.security.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.truth.security.dao.PowerDao;
import com.truth.security.mapper.PowerMapper;
import com.truth.security.model.PowerModel;

@Repository("PowerDao")
public class PowerDaoImpl implements PowerDao {

	Logger log = Logger.getLogger(PowerDaoImpl.class);
	
	@Resource
	private PowerMapper powerMapper;
	
	@Override
	public PowerModel getPowerModelById(String id) {
		final PowerModel power = new PowerModel();
		return power;
	}

	@Override
	public List<PowerModel> getAllPowers() {
		return powerMapper.getAllPowers();
	}

}
