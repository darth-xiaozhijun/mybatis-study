package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
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
		 * 接口,为什么能实例化?
		 * 
		 * 需要给接口一个实例化对象.
		 * 
		 * 使用的JDK的动态代理设计模式.
		 * 面向接口的代理设计模式(必须有接口)
		 * 
		 */
		/*LogMapper logMapper = session.getMapper(LogMapper.class);
		List<Log> list = logMapper.selAll();
		for (Log log : list) {
			System.out.println(log);
		}*/
		
		
		/*LogMapper logMapper = session.getMapper(LogMapper.class);
		List<Log> list = logMapper.selByAccInAccout("1", "2");
		for (Log log : list) {
			System.out.println(log);
		}*/
		
//		SqlSession session = factory.openSession(ExecutorType.BATCH);
		Scanner input = new Scanner(System.in);
		System.out.println("请输入转账帐号:");
		String accout = input.nextLine();
		System.out.println("请输入收款帐号");
		String accin = input.nextLine();
		
		LogMapper mapper = session.getMapper(LogMapper.class);
//		List<Log> list = mapper.selByAccinAccout(accout, accin);
//		System.out.println(list);
//		Log log = new Log();
//		log.setId(1);
//		log.setAccOut(accout);
//		log.setAccIn(accin);
//		int index = mapper.upd(log);
//		System.out.println(index);
//		Log log = new Log();
//		mapper.selByLog(new Log());
//		mapper.upd(new Log());
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			list.add(i);
		}
		
		mapper.ins(list);
		
//		mapper.selIn(list);
		
		
		session.commit();
		session.close();
		System.out.println("程序执行结束");
		
		session.close();
		System.out.println("程序执行结束");
	}
}
