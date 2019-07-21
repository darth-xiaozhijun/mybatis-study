package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pojo.Flower;

public class Test {

	public static void main(String[] args) throws IOException {
		
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//使用工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//生产SqlSession
		SqlSession session=factory.openSession();
		
		List<Flower> list = session.selectList("a.b.selAll");
		for (Flower flower : list) {
			System.out.println(flower.toString());
		}
		
		int count = session.selectOne("a.b.selById");
		System.out.println(count);
		
		//把数据库中哪个列的值当作map的key
		Map<Object, Object> map = session.selectMap("a.b.c", "name");
		System.out.println(map);
		
		session.close();
	}
}
