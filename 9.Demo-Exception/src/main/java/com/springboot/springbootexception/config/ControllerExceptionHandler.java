package com.springboot.springbootexception.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

    //自定指定异常的返回信息
    @ExceptionHandler(RuntimeException.class)
    //指定返回的响应码
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> handleUserNotExistsException(RuntimeException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "123");
        map.put("oldmessage",e.getMessage());
        map.put("message", "RuntimeException出现了,各单位注意!");
        return map;
    }
}
