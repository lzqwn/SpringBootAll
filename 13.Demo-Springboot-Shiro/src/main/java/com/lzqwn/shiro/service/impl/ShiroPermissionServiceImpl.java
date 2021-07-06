package com.lzqwn.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzqwn.shiro.dao.ShiroPermissionDao;
import com.lzqwn.shiro.entity.ShiroPermission;
import com.lzqwn.shiro.service.ShiroPermissionService;
import org.springframework.stereotype.Service;

/**
 * 权限表(ShiroPermission)表服务实现类
 *
 * @author lzqwn
 * @since 2021-07-14 16:19:33
 */
@Service("shiroPermissionService")
public class ShiroPermissionServiceImpl extends ServiceImpl<ShiroPermissionDao, ShiroPermission> implements ShiroPermissionService {

}