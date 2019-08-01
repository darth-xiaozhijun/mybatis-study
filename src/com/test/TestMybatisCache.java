package com.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMybatisCache {

	public static void main(String[] args) {
		
		InputStream is;
		try {
			is = Resources.getResourceAsStream("mybatis.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			
			SqlSession session = factory.openSession();
			session.selectList("com.mapper.LogMapper.selAll");
			session.selectList("com.mapper.LogMapper.selAll");
			session.commit();
			
			SqlSession session1 = factory.openSession();
			session1.selectList("com.mapper.LogMapper.selAll");
			session1.selectList("com.mapper.LogMapper.selAll");
			session1.close();
			System.out.println("程序运行结束");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
