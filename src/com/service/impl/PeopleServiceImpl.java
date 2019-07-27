package com.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import com.pojo.People;
import com.service.PeopleService;
import com.utils.PageInfo;


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
	
	@Override
	public PageInfo<People> showPage(int pageSize, int pageNumber) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		PageInfo<People> pi = new PageInfo<>();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		Map<String,Object> map =new HashMap<>();
		map.put("pageStart",pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		pi.setList(session.selectList("com.mapper.PeopleMapper.page",map));
		
		//������
		long count = session.selectOne("com.mapper.PeopleMapper.selCount");
		
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		return pi;
	}

}
