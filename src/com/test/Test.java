package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pojo.Flower;
import com.pojo.People;

public class Test {

	public static void main(String[] args) throws IOException {
		
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//使用工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//生产SqlSession
		SqlSession session=factory.openSession();
		
//		List<Flower> list = session.selectList("com.pojo.Flower.selAll");
//		for (Flower flower : list) {
//			System.out.println(flower.toString());
//		}
//		
//		int count = session.selectOne("com.pojo.Flower.selById");
//		System.out.println(count);
//		
//		//把数据库中哪个列的值当作map的key
//		Map<Object, Object> map = session.selectMap("com.pojo.Flower.c", "name");
//		System.out.println(map);
		
		People people = session.selectOne("com.pojo.People.selById", 2);
		System.out.println(people);
		
		Map<String, Object> map = new HashMap<>();
		map.put("id", 2);
		map.put("name", "李四");
		People people2 = session.selectOne("com.pojo.People.selByMap", map);
		System.out.println(people2);
		
		//显示几个
		int pageSize = 2;
		//第几页
		int pageNumber = 1;
		//如果希望传递多个参数,可以使用对象或map
		Map<String,Object> map2 = new HashMap<>();
		map2.put("pageSize", pageSize);
		map2.put("pageStart", pageSize*(pageNumber-1));
		List<People> p = session.selectList("com.pojo.People.page",map2);
		System.out.println(p);
		
		session.close();
	}
}
