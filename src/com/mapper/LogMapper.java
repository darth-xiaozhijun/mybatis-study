package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.Log;

public interface LogMapper {
	
	List<Log> selAll();

	/**
	 * mybatis把参数转换为map了,其中@Param("key") 参数内容就是map的value
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
