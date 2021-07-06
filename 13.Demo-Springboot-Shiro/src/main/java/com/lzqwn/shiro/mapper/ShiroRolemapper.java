package com.lzqwn.shiro.mapper;


import com.lzqwn.shiro.entity.ShiroRole;

public interface ShiroRolemapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShiroRole record);

    int insertSelective(ShiroRole record);

    ShiroRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShiroRole record);

    int updateByPrimaryKey(ShiroRole record);
}