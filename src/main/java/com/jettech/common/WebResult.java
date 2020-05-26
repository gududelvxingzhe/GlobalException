package com.jettech.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebResult {

    private String status; //状态码
    private String msg; //提示信息
    private Object data; //数据


}
