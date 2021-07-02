package com.lzqwn.orm.mybatis.MapperAndPage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * <p>
 * 启动器
 * </p>
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.lzqwn.orm.mybatis.MapperAndPage.mapper"})
public class SpringBootDemoOrmMybatisMapperPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoOrmMybatisMapperPageApplication.class, args);
    }
}
