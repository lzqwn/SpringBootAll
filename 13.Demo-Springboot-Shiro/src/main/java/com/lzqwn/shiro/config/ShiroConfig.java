package com.lzqwn.shiro.config;

import com.lzqwn.shiro.cache.RedisCacheManager;
import com.lzqwn.shiro.shiro.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(SecurityManager securityManager) {
        //创建shiro的filter
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 配置访问权限 必须是LinkedHashMap，因为它必须保证有序
        // 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 --> : 这是一个坑，一不小心代码就不好使了
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        //anon 设置为公共资源  放行资源放在下面
        map.put("/login.html","anon");
        map.put("/user/getImage","anon");
        map.put("/user/register","anon");
        map.put("/user/registerview","anon");
        map.put("/user/login","anon");
        map.put("/**", "authc");

        //配置记住我或认证通过可以访问的地址
        map.put("/order/save", "user");
        //默认认证界面路径
        shiroFilterFactoryBean.setLoginUrl("/user/loginview");
        //配置授权规则
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //必须设置 SecurityManager,Shiro的核心安全接口
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        return shiroFilterFactoryBean;
    }

    //安全管理器
    @Bean
    public DefaultWebSecurityManager webSecurityManager(Realm realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    //使用自定义realm
    @Bean
    public Realm getRealm() {
        //凭证校验匹配器
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //加密算法
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        //哈希散列次数
        hashedCredentialsMatcher.setHashIterations(1024);
        CustomerRealm realm = new CustomerRealm();
        realm.setCredentialsMatcher(hashedCredentialsMatcher);
        //开启缓存管理
        realm.setCacheManager(new RedisCacheManager());
        //开启全局缓存
        realm.setCachingEnabled(true);
        //认证认证缓存
        realm.setAuthenticationCachingEnabled(true);
        realm.setAuthenticationCacheName("authenticationCache");
        //开启授权缓存
        realm.setAuthorizationCachingEnabled(true);
        realm.setAuthorizationCacheName("authorizationCache");
        return realm;
    }
}
