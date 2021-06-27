package com.lzqwn.exception.handler.exception;

import com.lzqwn.exception.handler.constant.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//添加父类的属性来重写equals与hashcode方法
//@Data默认调用@EqualsAndHashCode(callSuper = false)
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {
    private Integer code;
    private String message;

    public BaseException(Status status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
