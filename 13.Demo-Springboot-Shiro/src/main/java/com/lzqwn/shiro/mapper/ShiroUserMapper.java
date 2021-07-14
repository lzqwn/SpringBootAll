package com.lzqwn.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzqwn.shiro.entity.ShiroUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表(ShiroUser)表数据库访问层
 *
 * @author lzqwn
 * @since 2021-07-14 17:18:26
 */
@Mapper
public interface ShiroUserMapper extends BaseMapper<ShiroUser> {

}