package com.lzqwn.shiro.shiro;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.lzqwn.shiro.entity.ShiroUser;
import com.lzqwn.shiro.mapper.ShiroUserMapper;
import com.lzqwn.shiro.service.ShiroUserService;
import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRealm extends AuthorizingRealm {
    @Autowired
    ShiroUserService userService;

    //获取授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取登录的用户名,手机号或邮箱
        String principal = authenticationToken.getPrincipal().toString();
        //根据用户名查询用户信息
        QueryWrapper<ShiroUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ShiroUser::getUsername,principal);
        ShiroUser shiroUser = userService.getOne(queryWrapper);
        if (ObjectUtils.isNotEmpty(shiroUser))
        {
            //参数1:认证对象,2:数据库密码,3:盐,4:当前认证的方法名
            return new SimpleAuthenticationInfo(shiroUser,shiroUser.getPassword(),new SimpleByteSource(shiroUser.getSalt()),this.getName());
        }
        return null;
    }
}
