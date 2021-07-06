package com.lzqwn.shiro.mapper;

import com.lzqwn.shiro.entity.ShiroPermission;

public interface ShiroPermissionmapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShiroPermission record);

    int insertSelective(ShiroPermission record);

    ShiroPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShiroPermission record);

    int updateByPrimaryKey(ShiroPermission record);
}