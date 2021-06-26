package com.springboot.springbootjson.bean;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

//LowerDotCaseStrategy : userName --> user.name
//KebabCaseStrategy : userName --> user-name
//SnakeCaseStrategy : userName --> user_name
//LowerCaseStrategy : userName --> username
//UpperCamelCaseStrategy : userName --> UserName
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
@Data
public class User {

  public interface UserNameView {};
  public interface AllUserFieldView extends UserNameView {};

  @JsonView(AllUserFieldView.class)
  private Integer id;
  @JsonView(UserNameView.class)
  private String userName;
  @JsonView(AllUserFieldView.class)
  private String yesapiOneUsersPassword;
  @JsonView(AllUserFieldView.class)
  private String email;
  @JsonView(AllUserFieldView.class)
  private Date lastLoginTime;
}
