package com.springboot.RedisCache.service;

import com.springboot.RedisCache.bean.User;

public interface UserService {

    User getUser(Integer id);

    User updateUser(User user);

    void deleteUser(Integer id);

}
