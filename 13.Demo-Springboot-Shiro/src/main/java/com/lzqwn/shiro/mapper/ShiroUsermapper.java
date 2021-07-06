package com.lzqwn.shiro.mapper;

import com.lzqwn.shiro.entity.ShiroUser;

public interface ShiroUsermapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShiroUser record);

    int insertSelective(ShiroUser record);

    ShiroUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShiroUser record);

    int updateByPrimaryKey(ShiroUser record);
}