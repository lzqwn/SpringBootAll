package com.lzqwn.shiro.mapper;

import com.lzqwn.shiro.entity.ShiroUserRole;

public interface ShiroUserRolemapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShiroUserRole record);

    int insertSelective(ShiroUserRole record);

    ShiroUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShiroUserRole record);

    int updateByPrimaryKey(ShiroUserRole record);
}