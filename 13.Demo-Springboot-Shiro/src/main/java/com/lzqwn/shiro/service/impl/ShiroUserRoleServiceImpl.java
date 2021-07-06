package com.lzqwn.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzqwn.shiro.dao.ShiroUserRoleDao;
import com.lzqwn.shiro.entity.ShiroUserRole;
import com.lzqwn.shiro.service.ShiroUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户角色关系表(ShiroUserRole)表服务实现类
 *
 * @author lzqwn
 * @since 2021-07-14 16:19:35
 */
@Service("shiroUserRoleService")
public class ShiroUserRoleServiceImpl extends ServiceImpl<ShiroUserRoleDao, ShiroUserRole> implements ShiroUserRoleService {

}