package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mapper.TeacherMapper;
import com.pojo.Teacher;

public class TestAnnotation {

	public static void main(String[] args) throws IOException {
		
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
//		List<Teacher> list = teacherMapper.selectAll();
//		System.out.println(list);
		
		Teacher teacher = new Teacher();
//		teacher.setName("测试");
		teacher.setId(4);
		teacher.setName("王五");
//		int index = teacherMapper.insTeacher(teacher);
//		int index = teacherMapper.updTeacher(teacher);
//		int index = teacherMapper.delById(4);
//		System.out.println(index);
		
		List<Teacher> list = teacherMapper.selTeacher();
		System.out.println(list);
		
		session.commit();
		session.close();
		System.out.println("程序执行结束");
	}
}
