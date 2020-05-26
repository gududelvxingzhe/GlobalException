package com.jettech.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Description: 也可以通过注解的方式设置异常提示消息,直接在控制层使用
 * 
 * @date 2020年5月26日  
 *
 * @version 1.0  
 *
 * Copyright: Copyright (c) 2020
 *
 */
@ResponseStatus(code = HttpStatus.EXPECTATION_FAILED, reason = "用户名和密码不匹配!")
public class UserNameNotMatchPasswordException extends RuntimeException {

}
