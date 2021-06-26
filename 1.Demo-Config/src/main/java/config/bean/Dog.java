package config.bean;

import config.config.YamlPropertyLoaderFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
// 使用自定义yml时,必须要加入 自定义的yml 资源加载工厂类
@PropertySource(value = {"classpath:application.yml","classpath:test.yml"},factory = YamlPropertyLoaderFactory.class)
@ConfigurationProperties(prefix="dog")
@Data
public class Dog {
    private String name;
    private int age;
}
