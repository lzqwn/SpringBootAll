package com.lzqwn.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzqwn.shiro.entity.ShiroPermission;
import com.lzqwn.shiro.mapper.ShiroPermissionMapper;
import com.lzqwn.shiro.service.ShiroPermissionService;
import org.springframework.stereotype.Service;

/**
 * 权限表(ShiroPermission)表服务实现类
 *
 * @author lzqwn
 * @since 2021-07-14 17:18:24
 */
@Service("shiroPermissionService")
public class ShiroPermissionServiceImpl extends ServiceImpl<ShiroPermissionMapper, ShiroPermission> implements ShiroPermissionService {

}