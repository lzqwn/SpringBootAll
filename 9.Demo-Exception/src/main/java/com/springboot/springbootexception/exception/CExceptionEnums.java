package com.springboot.springbootexception.exception;

public enum CExceptionEnums
{
    SERVER_DO_ERROR                ("0001","交易处理失败"),
    SERVER_FTP_DOWN_ERROR        ("0002","从ftp下载文件失败"),
    SERVER_ALIYUN_UPLOAD_ERROR    ("0003","上传阿里云失败"),
    SERVER_IMG_ERROR            ("0004","图片错误"),
    SERVER_DB_ERROR                ("0005","数据库错误"),
    SERVER_OTHER_ERROR            ("1099","其他异常");

    private String ecode;

    private String emsg;
    CExceptionEnums(String ecode, String emsg) {
        this.ecode = ecode;
        this.emsg = emsg;
    }

    public String getEcode() {
        return ecode;
    }

    public String getEmsg() {
        return emsg;
    }

    public static CExceptionEnums statOf(String ecode) {
        for (CExceptionEnums state : values())
            if (state.getEcode().equals(ecode))
                return state;
        return null;
    }
}
