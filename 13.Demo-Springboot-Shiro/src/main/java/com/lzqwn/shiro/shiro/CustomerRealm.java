package com.lzqwn.shiro.shiro;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzqwn.shiro.entity.ShiroUser;
import com.lzqwn.shiro.service.ShiroUserService;
import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

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
        String principal = authenticationToken.getPrincipal().toString();
        QueryWrapper<ShiroUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ShiroUser::getUsername,principal);
        ShiroUser shiroUser = userService.getOne(queryWrapper);

        return null;
    }
}
