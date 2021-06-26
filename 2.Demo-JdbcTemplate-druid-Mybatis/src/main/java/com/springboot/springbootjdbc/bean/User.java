package com.springboot.springbootjdbc.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
  private long id;
  @NotNull(message="名字不能为空")
  private String username;
  private String yesapiOneUsersPassword;
  @Email
  private String email;
  private Date lastLoginTime;
}
