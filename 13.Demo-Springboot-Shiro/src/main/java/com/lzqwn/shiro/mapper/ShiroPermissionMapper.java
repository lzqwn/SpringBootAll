package com.lzqwn.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzqwn.shiro.entity.ShiroPermission;
import org.apache.ibatis.annotations.Mapper;

/**
 * 权限表(ShiroPermission)表数据库访问层
 *
 * @author lzqwn
 * @since 2021-07-14 17:18:25
 */
@Mapper
public interface ShiroPermissionMapper extends BaseMapper<ShiroPermission> {

}