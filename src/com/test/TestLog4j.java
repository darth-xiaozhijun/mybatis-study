package com.test;

import org.apache.log4j.Logger;

public class TestLog4j {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(TestLog4j.class);
		logger.debug("这是一个调试信息");
		logger.info("普通信息");
		
		try {
			int i = 5/0;
		} catch (Exception e) {
//			e.printStackTrace();
			logger.error(e.getMessage());
		}
		System.out.println("结束");
		
	}
}
