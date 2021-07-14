package com.lzqwn.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzqwn.shiro.entity.ShiroUserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户角色关系表(ShiroUserRole)表数据库访问层
 *
 * @author lzqwn
 * @since 2021-07-14 17:18:26
 */
@Mapper
public interface ShiroUserRoleMapper extends BaseMapper<ShiroUserRole> {

}