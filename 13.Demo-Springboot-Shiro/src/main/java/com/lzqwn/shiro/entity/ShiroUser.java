package com.lzqwn.shiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户表(ShiroUser)表实体类
 *
 * @author lzqwn
 * @since 2021-07-14 16:19:35
 */
@Data
@SuppressWarnings("serial")
public class ShiroUser extends Model<ShiroUser> {
    @TableId(type = IdType.AUTO)
    /**主键*/
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐值
     */
    private String salt;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 手机
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 生日
     */
    private Long birthday;
    /**
     * 性别，男-1，女-2
     */
    private Integer sex;
    /**
     * 状态，启用-1，禁用-0
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 更新时间
     */
    private Long updateTime;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}