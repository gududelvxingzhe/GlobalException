package com.jettech.exception;

/**
 *
 * Description: 自定义异常
 *
 * @date 2020年5月25日  
 *
 * @version 1.0  
 *
 * Copyright: Copyright (c) 2020
 *
 */
public class BaseException extends RuntimeException {

	private String code; //异常码
	
	public BaseException(String message, String code) {
		super(message);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
