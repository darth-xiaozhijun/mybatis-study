package com.service;

import java.io.IOException;
import java.util.List;

import com.pojo.People;
import com.utils.PageInfo;

public interface PeopleService {
	/**
	 * ��ʾȫ��
	 * @return
	 */
	List<People> show()  throws IOException;
	
	/**
	 * ��ҳ��ʾ
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	PageInfo<People> showPage(int pageSize,int pageNumber) throws IOException;
}
