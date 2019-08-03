package com.mapper;

import java.util.List;

import com.pojo.Student;
import com.pojo.StudentPageInfo;

public interface StudentMapper {
	
	List<Student> selByPage(StudentPageInfo pi);
	
	long selCountByPageInfo(StudentPageInfo pi);
}
