package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.Log;

public interface LogMapper {
	
	List<Log> selAll();

	/**
	 * mybatis�Ѳ���ת��Ϊmap��,����@Param("key") �������ݾ���map��value
	 * @param accin123
	 * @param accout3454235
	 * @return
	 */
	List<Log> selByAccInAccout(@Param("accin") String accin123,@Param("accout") String accout3454235);
	
	int upd(Log log);
	
	
	List<Log> selByLog(Log log);
	
	
	List<Log> selIn(List<Integer> list);
	
	
	int ins(List<Integer> list);
}
