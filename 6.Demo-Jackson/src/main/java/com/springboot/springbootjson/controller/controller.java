package com.springboot.springbootjson.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.springbootjson.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class controller {

    @Autowired
    ObjectMapper mapper;

    //绑定对象
    @RequestMapping("readjsonasobject")
    @ResponseBody
    public String readJsonAsObject() {
        try {
            String json = "{\"id\":null,\"username\":\"张三\",\"yesapiOneUsersPassword\":null,\"email\":\"1234567qq.com\",\"lastLoginTime\":\"2021-06-14 18:54:14\"}";
            User user = mapper.readValue(json, User.class);
            Date date = user.getLastLoginTime();
            return user.getUserName() + "====" + date.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //树遍历
    @RequestMapping("/readjsonstring")
    public String readjsonstring() {
        try {
            String json = "{\"name\":\"mrbird\",\"hobby\":{\"first\":\"sleep\",\"second\":\"eat\"}}";;
            JsonNode node = this.mapper.readTree(json);
            JsonNode hobby = node.get("hobby");
            String first = hobby.get("first").asText();
            return first + " " + hobby.get("second").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //序列化
    @RequestMapping("/serialization")
    public String serialization() {
        try {
            User user = new User();
            user.setUserName("张三");
            user.setEmail("1234567qq.com");
            user.setLastLoginTime(new Date());
            return mapper.writeValueAsString(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @GetMapping("/hello")
    public User getUser()
    {
        User user = new User();
        user.setUserName("张三");
        user.setEmail("1234567qq.com");
        user.setLastLoginTime(new Date());
        user.setYesapiOneUsersPassword("12345");
        user.setId(12);
        return user;
    }


}
