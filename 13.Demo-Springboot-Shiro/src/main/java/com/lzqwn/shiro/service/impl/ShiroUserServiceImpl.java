package com.lzqwn.shiro.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzqwn.shiro.entity.ShiroUser;
import com.lzqwn.shiro.mapper.ShiroUserMapper;
import com.lzqwn.shiro.service.ShiroUserService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户表(ShiroUser)表服务实现类
 *
 * @author lzqwn
 * @since 2021-07-14 17:18:26
 */
@Service("shiroUserService")
public class ShiroUserServiceImpl extends ServiceImpl<ShiroUserMapper, ShiroUser> implements ShiroUserService {

    @Autowired
    ShiroUserMapper shiroUserMapper;

    @Override
    public void register(ShiroUser user) {
        //生成随机盐
        String salt = RandomUtil.randomString(8);
        //生成密文:明文+salt+哈希散列
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 1024);
        user.setSalt(salt);
        user.setPassword(md5Hash.toHex());
        shiroUserMapper.insert(user);
    }
}