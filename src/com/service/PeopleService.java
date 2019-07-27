package com.service;

import java.io.IOException;
import java.util.List;

import com.pojo.People;
import com.utils.PageInfo;

public interface PeopleService {
	/**
	 * 显示全部
	 * @return
	 */
	List<People> show()  throws IOException;
	
	/**
	 * 分页显示
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	PageInfo<People> showPage(int pageSize,int pageNumber) throws IOException;
}
