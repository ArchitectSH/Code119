package com.code119.myapp.businessLogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.code119.myapp.controller.HomeController;

public class LogAdvice {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	public void printLog(){
		logger.info("[공통 로그] 비즈니스 로직 수행 전 동작");
	}
}
