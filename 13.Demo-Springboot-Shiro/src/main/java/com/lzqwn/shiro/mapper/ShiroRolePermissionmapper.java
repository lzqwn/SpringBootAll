package com.lzqwn.shiro.mapper;

import com.lzqwn.shiro.entity.ShiroRolePermission;

public interface ShiroRolePermissionmapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShiroRolePermission record);

    int insertSelective(ShiroRolePermission record);

    ShiroRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShiroRolePermission record);

    int updateByPrimaryKey(ShiroRolePermission record);
}