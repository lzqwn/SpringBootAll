package com.lzqwn.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzqwn.shiro.dao.ShiroUserDao;
import com.lzqwn.shiro.entity.ShiroUser;
import com.lzqwn.shiro.service.ShiroUserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(ShiroUser)表服务实现类
 *
 * @author lzqwn
 * @since 2021-07-14 16:19:35
 */
@Service("shiroUserService")
public class ShiroUserServiceImpl extends ServiceImpl<ShiroUserDao, ShiroUser> implements ShiroUserService {

}