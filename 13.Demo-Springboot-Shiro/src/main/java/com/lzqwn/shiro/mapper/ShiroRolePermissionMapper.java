package com.lzqwn.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzqwn.shiro.entity.ShiroRolePermission;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色权限关系表(ShiroRolePermission)表数据库访问层
 *
 * @author lzqwn
 * @since 2021-07-14 17:18:26
 */
@Mapper
public interface ShiroRolePermissionMapper extends BaseMapper<ShiroRolePermission> {

}