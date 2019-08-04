package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pojo.Student;
import com.pojo.Teacher;

public class TestResultMap {

	public static void main(String[] args) throws IOException {
		
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		
//		List<Teacher> list = session.selectList("com.mapper.TeacherMapper.selAll");
//		List<Student> list = session.selectList("com.mapper.StudentMapper.selAll1");
//		List<Teacher> list = session.selectList("com.mapper.TeacherMapper.selAll");
		List<Teacher> list = session.selectList("com.mapper.TeacherMapper.selAll1");
		for (Teacher teacher : list) {
			System.out.println(teacher);
		}

		System.out.println(list);
		
		session.close();
		System.out.println("≥Ã–Ú÷¥––Ω· ¯");
	}
}
