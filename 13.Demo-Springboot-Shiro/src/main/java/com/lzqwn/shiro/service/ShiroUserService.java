package com.lzqwn.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzqwn.shiro.entity.ShiroUser;

/**
 * 用户表(ShiroUser)表服务接口
 *
 * @author lzqwn
 * @since 2021-07-14 17:18:26
 */
public interface ShiroUserService extends IService<ShiroUser> {
    void register(ShiroUser user);
}