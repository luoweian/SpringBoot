package com.willam.girl.properties;
/*
 *Created by William on 2017/11/12 0012
 */

import lombok.Data;


/**
 * http请求返回的最外层对象
 */
@Data
public class Result<T> {
    /**错误码*/
    private Integer code;
    /** 提示信息*/
    private String msg;
    /** 数据*/
    private T data;
}
