package com.lzqwn.shiro.config;

import com.lzqwn.shiro.shiro.CustomerRealm;
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
        Map<String, String> map = new LinkedHashMap<>();
        //anon 设置为公共资源  放行资源放在下面
        map.put("/login.html","anon");
        map.put("/user/getImage","anon");
        map.put("/user/register","anon");
        map.put("/user/registerview","anon");
        map.put("/user/login","anon");
        map.put("/**", "authc");
        //默认认证界面路径
        shiroFilterFactoryBean.setLoginUrl("/user/loginview");
        //配置授权规则
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //注入安全管理器
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
        return new CustomerRealm();
    }
}
