package com.service;

import java.io.IOException;
import java.util.List;

import com.pojo.People;

public interface PeopleService {
	/**
	 * ÏÔÊ¾È«²¿
	 * @return
	 */
	List<People> show()  throws IOException;
}
