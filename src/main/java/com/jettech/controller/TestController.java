package com.jettech.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jettech.common.Config;
import com.jettech.common.WebResult;
import com.jettech.exception.BaseException;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@GetMapping("/data")
	public Object getData() {
		Map<String, String> map = new HashMap<>();
		map.put("userName", "alibaba");
		return WebResult.builder().msg("操作成功").status(Config.SUCCESS).data(map).build();
	}
	
    //occur exception
    @GetMapping("/exception/unknownException")
    public Object occurUnknownException() throws Exception {
        int i = 1/0;
        return null;
    }
    
    //occur exception explicitly
    @GetMapping("/exception/businessException")
    public Object occurBusinessException(){
        throw new BaseException("some error has occurred!", Config.FAIL);
    }
    
    //test the actions
    @GetMapping("functions/{action}")
    public Object function(@PathVariable("action") String action, @RequestParam(value = "url", required = false) String url){
    	
       if("msg".equals(action)){
            //tell it to show a message
            return WebResult.builder().msg("this is a message").build();
        }else if ("other".equals(action)) {
                return WebResult.builder().msg("url is not allowed null value").build();
        } else {
            //do nothing but return a default response
            return WebResult.builder().build();
        }
    }
}
