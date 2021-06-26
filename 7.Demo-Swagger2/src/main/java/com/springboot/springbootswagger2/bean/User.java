package com.springboot.springbootswagger2.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("用户实体")
@Data
public class User {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("名称")
    private String userName;
    @ApiModelProperty("密码")
    private String yesapiOneUsersPassword;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("最后登录日期")
    private Date lastLoginTime;
}
