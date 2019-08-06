package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.pojo.Airport;

public interface AirportMapper {
	
	/**
	 * 起飞机场
	 * @return
	 */
	@Select("select * from airport where id in (select distinct takeid from airplane)")
	List<Airport> selTakePort();
	
	/**
	 * 降落机场
	 * @return
	 */
	@Select("select * from airport where id in (select distinct landid from airplane)")
	List<Airport> selLandPort();
}
