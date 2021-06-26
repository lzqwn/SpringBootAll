package config.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Cat {
    //使用这个必须要有注入
    @Value("${mycat.name}")
    private String name;
    private int age;
}
