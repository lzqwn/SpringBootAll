package com.lzqwn.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzqwn.shiro.dao.ShiroRolePermissionDao;
import com.lzqwn.shiro.entity.ShiroRolePermission;
import com.lzqwn.shiro.service.ShiroRolePermissionService;
import org.springframework.stereotype.Service;

/**
 * 角色权限关系表(ShiroRolePermission)表服务实现类
 *
 * @author lzqwn
 * @since 2021-07-14 16:19:35
 */
@Service("shiroRolePermissionService")
public class ShiroRolePermissionServiceImpl extends ServiceImpl<ShiroRolePermissionDao, ShiroRolePermission> implements ShiroRolePermissionService {

}