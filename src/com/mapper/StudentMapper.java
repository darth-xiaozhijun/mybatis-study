package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.pojo.Student;
import com.pojo.StudentPageInfo;

public interface StudentMapper {
	
	List<Student> selByPage(StudentPageInfo pi);
	
	long selCountByPageInfo(StudentPageInfo pi);
	
	@Select("select * from student where tid=#{0}")
	List<Student> selectByTid(int tid);
	
}
