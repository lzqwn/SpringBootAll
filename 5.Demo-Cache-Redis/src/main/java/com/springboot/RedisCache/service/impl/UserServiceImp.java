package com.springboot.RedisCache.service.impl;

import com.springboot.RedisCache.bean.User;
import com.springboot.RedisCache.mapper.UserMapper;
import com.springboot.RedisCache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "user")
@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper userMapper;

    @Cacheable(key = "#id")
    @Override
    public User getUser(Integer id) {
        return this.userMapper.getUser(id);
    }

    //数据更新后,缓存如不更新,用户将得到脏数据,所以返回对象
    @CachePut(key = "#user.id")
    @Override
    public User updateUser(User user) {
        this.userMapper.updateUser(user);
        return this.userMapper.getUser(user.getId());
    }

    //allEntries默认为false,true是删除所有user下的缓存
    @CacheEvict(key = "#id",allEntries = true)
    @Override
    public void deleteUser(Integer id) {
        this.userMapper.deleteUser(id);
    }
}
