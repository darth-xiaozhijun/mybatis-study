package com.test;

import org.apache.log4j.Logger;

public class TestLog4j {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(TestLog4j.class);
		logger.debug("����һ��������Ϣ");
		logger.info("��ͨ��Ϣ");
		
		try {
			int i = 5/0;
		} catch (Exception e) {
//			e.printStackTrace();
			logger.error(e.getMessage());
		}
		System.out.println("����");
		
	}
}
