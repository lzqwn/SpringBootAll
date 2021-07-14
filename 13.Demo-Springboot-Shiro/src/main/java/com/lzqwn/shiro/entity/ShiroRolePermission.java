package com.lzqwn.shiro.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 角色权限关系表(ShiroRolePermission)表实体类
 *
 * @author lzqwn
 * @since 2021-07-14 16:43:07
 */
@Data
@SuppressWarnings("serial")
public class ShiroRolePermission extends Model<ShiroRolePermission> {
  @TableId(type = IdType.AUTO)
    /**角色主键*/
    private Long roleId;
    /**权限主键*/
    private Long permissionId;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }
    }