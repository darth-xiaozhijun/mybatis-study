package com.service.impl;

import java.util.List;

import com.mapper.AirplaneMapper;
import com.pojo.Airplane;
import com.service.AirplaneService;
import com.utils.MyBatisUtil;

public class AirplaneServiceImpl implements AirplaneService {

	@Override
	public List<Airplane> show(int takeid, int landid) {
		return MyBatisUtil.getSession().getMapper(AirplaneMapper.class).selByTakeidLandid(takeid, landid);
	}

}
