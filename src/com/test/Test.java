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
		//ʹ�ù������ģʽ
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//����SqlSession
		SqlSession session=factory.openSession();
		
//		List<Flower> list = session.selectList("com.pojo.Flower.selAll");
//		for (Flower flower : list) {
//			System.out.println(flower.toString());
//		}
//		
//		int count = session.selectOne("com.pojo.Flower.selById");
//		System.out.println(count);
//		
//		//�����ݿ����ĸ��е�ֵ����map��key
//		Map<Object, Object> map = session.selectMap("com.pojo.Flower.c", "name");
//		System.out.println(map);
		
		People people = session.selectOne("com.mapper.PeopleMapper.selById", 2);
		System.out.println(people);
		
		Map<String, Object> map = new HashMap<>();
		map.put("id", 2);
		map.put("name", "����");
		People people2 = session.selectOne("com.mapper.PeopleMapper.selByMap", map);
		System.out.println(people2);
		
		//��ʾ����
		int pageSize = 2;
		//�ڼ�ҳ
		int pageNumber = 1;
		//���ϣ�����ݶ������,����ʹ�ö����map
		Map<String,Object> map2 = new HashMap<>();
		map2.put("pageSize", pageSize);
		map2.put("pageStart", pageSize*(pageNumber-1));
		List<People> peoples = session.selectList("com.mapper.PeopleMapper.page",map2);
		System.out.println(peoples);
		
		People p = new People();
		p.setName("����name1");
		p.setAge(88);
		try {
			int index = session.insert("com.mapper.PeopleMapper.ins", p);
			if(index>0){
				System.out.println("�ɹ�");
			}else{
				System.out.println("ʧ��");
			}
		} catch (Exception e1) {
//			e1.printStackTrace();
			session.rollback();
		}
		p.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		try {
			int index1 = session.insert("com.mapper.PeopleMapper.ins", p);
			if(index1>0){
				System.out.println("�ɹ�");
			}else{
				System.out.println("ʧ��");
			}
		} catch (Exception e) {
//			e.printStackTrace();
			session.rollback();
		}
		session.commit();
		
		session.close();
	}
}
