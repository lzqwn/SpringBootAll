package com.lzqwn.orm.mybatis.MapperAndPage.mapper;


import com.lzqwn.orm.mybatis.MapperAndPage.entity.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * <p>
 * UserMapper
 * </p>
 */
@Component
public interface UserMapper extends Mapper<User>, MySqlMapper<User> {
}
