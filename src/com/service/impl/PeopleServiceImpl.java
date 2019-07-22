package com.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import com.pojo.People;
import com.service.PeopleService;


/**
 * �����ݷ��ʲ㴦���쳣���ڿ������д����쳣,service��ֻ�׳��쳣.
 * @author Administrator
 *
 */
public class PeopleServiceImpl implements PeopleService {

	@Override
	public List<People> show() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//ǰ���ǹ���       ʵ������������ʱʹ�õ���  ���������ģʽ   ���Ʊ�־:������Builder
		//���������ģʽ����: �򻯶���ʵ��������
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		List<People> list = session.selectList("com.mapper.PeopleMapper.selAll");
		session.close();
		return list;
	}

}
