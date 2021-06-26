package com.springboot.springbootexception.exception;

/**
 * 自定义异常
 */
public class CException extends Exception implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    /*
     * 模版异常
     */
    private CExceptionEnums exceptionEnums;
    /*
     * 自定义异常信息
     */
    private String errorDetail;

    /**
     * 带自定义异常信息的构造方法
     * @param exceptionEnums
     * @param errorDetail
     */
    public CException(CExceptionEnums exceptionEnums,String errorDetail){
        this.exceptionEnums = exceptionEnums;
        this.errorDetail = errorDetail;
    }

    /**
     * 模版异常的构造方法
     * @param exceptionEnums
     */
    public CException(CExceptionEnums exceptionEnums){
        this.exceptionEnums = exceptionEnums;
    }

    public CExceptionEnums getExceptionEnums() {
        return exceptionEnums;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }
}

