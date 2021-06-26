package com.springboot.springbootexception.controller;

import com.springboot.springbootexception.exception.CException;
import com.springboot.springbootexception.exception.CExceptionEnums;

public class exceptionTest {

    public static void main(String[] args) {
        try{
            //自己方法内部的异常可以统一用exception捕获，在catch中再抛出CxzException，在上一层方法里用CxzException捕获
            //自定义异常用法示例
            if(true){
                //可以使用模版异常
                throw new CException(CExceptionEnums.SERVER_DO_ERROR);
            }
            if(false){
                //也可以自定义msg信息
                throw new CException(CExceptionEnums.SERVER_DO_ERROR,"自定义msg信息");
            }

            dbfunc();

        }catch(CException ex){
            //捕获自定义异常
            ex.printStackTrace();
            System.out.println(ex.toString());
            CExceptionEnums enums = ex.getExceptionEnums();
            //此处逻辑，若无自定义信息，则使用默认enums中的msg，如有，则使用自定义异常信息
            if (null != ex.getErrorDetail()){
                //如果自定义信息不是null，就使用自定义信息
                String cmsg = ex.getErrorDetail();
            }

        }catch(Exception ex){

        }
    }

    /**
     * 假设这是个与数据库有关的方法
     * 方法内抛异常可以用Exception捕获，再抛出CxzException，上级去处理
     * @throws CException
     */
    private static void dbfunc() throws CException {
        try{
            if(true){
                throw new Exception("数据库异常信息");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());//打印日志--异常中可能有数据库表或字段的名字，不对外暴露
            throw new CException(CExceptionEnums.SERVER_DB_ERROR);//对外不暴露数据库信息，只显示模版异常
        }
    }
}
