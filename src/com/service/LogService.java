package com.service;

import java.io.IOException;

import com.pojo.Log;
import com.utils.PageInfo;

public interface LogService  {
	/**
	 * ��ҳ��ʾ
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	PageInfo<Log> showPage(int pageSize,int pageNumber) throws IOException;
}
