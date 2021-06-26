package config.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Component
@ConfigurationProperties(prefix = "fish")
@Data
@Validated
public class Fish {
    @NotNull(message="名字不能为空")
    private String name;
    @Email
    private String email;
    @Max(value=120,message="年龄最大不能查过120")
    private int age;
}
