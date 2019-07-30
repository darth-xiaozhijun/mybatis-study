package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mapper.LogMapper;
import com.pojo.Log;

public class TestDynamicSql {

	public static void main(String[] args) throws IOException {
		
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		
		/*
		 * �ӿ�,Ϊʲô��ʵ����?
		 * 
		 * ��Ҫ���ӿ�һ��ʵ��������.
		 * 
		 * ʹ�õ�JDK�Ķ�̬�������ģʽ.
		 * ����ӿڵĴ������ģʽ(�����нӿ�)
		 * 
		 */
		/*LogMapper logMapper = session.getMapper(LogMapper.class);
		List<Log> list = logMapper.selAll();
		for (Log log : list) {
			System.out.println(log);
		}*/
		
		
		LogMapper logMapper = session.getMapper(LogMapper.class);
		List<Log> list = logMapper.selByAccInAccout("1", "2");
		for (Log log : list) {
			System.out.println(log);
		}
		
		session.close();
		System.out.println("����ִ�н���");
	}
}
