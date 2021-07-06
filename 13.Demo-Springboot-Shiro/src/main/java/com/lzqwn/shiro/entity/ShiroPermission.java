package com.lzqwn.shiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 权限表(ShiroPermission)表实体类
 *
 * @author lzqwn
 * @since 2021-07-14 16:19:31
 */
@Data
@SuppressWarnings("serial")
public class ShiroPermission extends Model<ShiroPermission> {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 权限名
     */
    private String name;
    /**
     * 类型为页面时，代表前端路由地址，类型为按钮时，代表后端接口地址
     */
    private String url;
    /**
     * 权限类型，页面-1，按钮-2
     */
    private Integer type;
    /**
     * 权限表达式
     */
    private String permission;
    /**
     * 后端接口访问方式
     */
    private String method;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 父级id
     */
    private Long parentId;

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