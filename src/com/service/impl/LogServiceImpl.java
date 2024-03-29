package com.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mapper.LogMapper;
import com.pojo.Log;
import com.service.LogService;
import com.utils.MyBatisUtil;
import com.utils.PageInfo;

public class LogServiceImpl implements LogService {

	@Override
	public PageInfo<Log> showPage(int pageSize, int pageNumber) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		Map<String,Object> param = new HashMap<>();
		param.put("pageStart",pageSize*(pageNumber-1));
		param.put("pageSize", pageSize);
		List<Log> list = session.selectList("com.mapper.LogMapper.selByPage",param);
		long count = session.selectOne("com.mapper.LogMapper.selCount");
		PageInfo<Log> pi = new PageInfo<>();
		pi.setList(list);
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		return pi;
	}

	@Override
	public int ins(Log log) {
		SqlSession session = MyBatisUtil.getSession();
		LogMapper mapper = session.getMapper(LogMapper.class);
		return mapper.insert(log);
	}
}
