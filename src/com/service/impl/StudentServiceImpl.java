package com.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mapper.StudentMapper;
import com.mapper.TeacherMapper;
import com.pojo.Student;
import com.pojo.StudentPageInfo;
import com.service.StudentService;
import com.utils.MyBatisUtil;

public class StudentServiceImpl implements  StudentService{

	@Override
	public StudentPageInfo showPage(String sname, String tname, String pageSizeStr, String pageNumberStr) {
		int pageSize = 2;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		int pageNumber = 1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		
		StudentPageInfo pi = new StudentPageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		pi.setPageStart((pageNumber-1)*pageSize);
		pi.setTname(tname);
		pi.setSname(sname);
		
		List<Student> list = studentMapper.selByPage(pi);
		//查询出每个学生对应的老师信息
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		for (Student student : list) {
			student.setTeacher(teacherMapper.selById(student.getTid()));
		}
		pi.setList(list);
		long count = studentMapper.selCountByPageInfo(pi);
		
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		
		return pi;
	}

}
