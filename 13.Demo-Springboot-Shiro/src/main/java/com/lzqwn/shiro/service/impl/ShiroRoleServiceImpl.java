package com.lzqwn.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzqwn.shiro.dao.ShiroRoleDao;
import com.lzqwn.shiro.entity.ShiroRole;
import com.lzqwn.shiro.service.ShiroRoleService;
import org.springframework.stereotype.Service;

/**
 * 角色表(ShiroRole)表服务实现类
 *
 * @author lzqwn
 * @since 2021-07-14 16:19:35
 */
@Service("shiroRoleService")
public class ShiroRoleServiceImpl extends ServiceImpl<ShiroRoleDao, ShiroRole> implements ShiroRoleService {

}