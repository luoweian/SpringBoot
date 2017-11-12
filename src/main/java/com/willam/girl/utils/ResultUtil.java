package com.willam.girl.utils;/*
 *Created by William on 2017/11/12 0012
 */

import com.willam.girl.properties.Result;

public class ResultUtil {
    public static Result setData(Integer code, String msg, Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
