package com.service;

import com.pojo.StudentPageInfo;

public interface StudentService {
	
	StudentPageInfo showPage(String sname,String tname,String pageSize,String pageNumber);
}
