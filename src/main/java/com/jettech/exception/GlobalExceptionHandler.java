package com.jettech.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jettech.common.Config;
import com.jettech.common.WebResult;

/**
 * Description: 全局异常处理，捕获所有controller中抛出的异常
 *
 * @date 2020年5月25日  
 *
 * @version 1.0  
 *
 * Copyright: Copyright (c) 2020
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	//处理自定义异常
	@ExceptionHandler(BaseException.class)
	@ResponseBody
	public Object customHandler(BaseException e) {
		logger.info("自定义异常……");
		e.printStackTrace();
		return WebResult.builder().status(e.getCode()).msg(e.getMessage()).build();
	}
	
	//其他未处理异常
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public Object exceptionHandler(Exception e) {
		logger.info("其他未处理异常……");
		e.printStackTrace();
		return WebResult.builder().status(Config.FAIL).msg("系统错误！").build();
	}
}
