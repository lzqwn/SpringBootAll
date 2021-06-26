package com.springboot.RedisCache.bean;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class User {
  private Integer id;
  @NotNull(message="名字不能为空")
  private String username;
  private String yesapiOneUsersPassword;
  @Email
  private String email;
  private Date lastLoginTime;
}
