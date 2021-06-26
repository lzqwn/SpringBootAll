package com.springboot.springbootjdbc.controller;

import com.springboot.springbootjdbc.bean.User;
import com.springboot.springbootjdbc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mybatis")
public class MybatisController
{
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/user")
    public String addUser()
    {
        User user = User.builder().username("张三1")
                .email("29123545@qq.com")
                .lastLoginTime(new Date())
                .yesapiOneUsersPassword("123456").build();
        userMapper.addUser(user);
        return "添加用户成功";
    }
    @PutMapping("/user")
    public String updateUser()
    {
        User user = User.builder().id(1).username("法外狂徒")
                .email("292355456@168.com")
                .lastLoginTime(new Date())
                .yesapiOneUsersPassword("root").build();
        userMapper.updateUser(user);
        return "修改用户成功";
    }

    @DeleteMapping("/user")
    public String deleteUser()
    {
        userMapper.deleteUser(2);
        return "删除用户成功";
    }
    @GetMapping("/user")
    public String getUser()
    {
        List<User> userList = userMapper.getUsers();
        return "查询用户成功";
    }
}
