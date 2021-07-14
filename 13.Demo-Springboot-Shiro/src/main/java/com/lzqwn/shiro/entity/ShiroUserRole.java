package com.lzqwn.shiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色关系表(ShiroUserRole)表实体类
 *
 * @author lzqwn
 * @since 2021-07-14 17:18:26
 */
@Data
@SuppressWarnings("serial")
public class ShiroUserRole extends Model<ShiroUserRole> {
    @TableId(type = IdType.AUTO)
    private Long userId;
    /**
     * 角色主键
     */
    private Long roleId;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}