package com.springboot.RedisCache.controller;

import com.springboot.RedisCache.bean.User;
import com.springboot.RedisCache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mybatis")
public class MybatisController
{
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String getUser(Integer num)
    {
        User user = userService.getUser(num);
        System.out.println("第一条数据===="+user.toString());
        User user2 = userService.getUser(num);
        System.out.println("第二条数据===="+user2.toString());
        return user2.toString();
    }

    @GetMapping("/user1")
    public String updateUser()
    {
        User user2 = userService.getUser(4);
        user2.setUsername("gdsgsdgf");
        user2 = userService.updateUser(user2);
        return user2.toString();
    }

    @GetMapping("/user2")
    public String deleteUser()
    {
        userService.deleteUser(1);
        return "删除成功";
    }
}
