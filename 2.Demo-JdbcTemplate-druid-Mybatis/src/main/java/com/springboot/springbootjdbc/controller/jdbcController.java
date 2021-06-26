package com.springboot.springbootjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class jdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @RequestMapping("/list")
    public List<Map<String, Object>> userList()
    {
        String sql = "select * from user";
        return jdbcTemplate.queryForList(sql);
    }
}
