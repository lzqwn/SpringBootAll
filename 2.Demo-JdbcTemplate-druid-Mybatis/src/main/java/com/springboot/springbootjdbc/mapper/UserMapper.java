package com.springboot.springbootjdbc.mapper;

import com.springboot.springbootjdbc.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();
    @Select("select * from user where id=#{id}")
    User getUser(Integer id);
    @Insert("insert into user(id,username,yesapi_one_users_password,email,last_login_time) " +
            "values(#{id},#{username},#{yesapiOneUsersPassword},#{email},#{lastLoginTime})")
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
}
