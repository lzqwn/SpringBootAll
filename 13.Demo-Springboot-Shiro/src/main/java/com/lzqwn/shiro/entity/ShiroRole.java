package com.lzqwn.shiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色表(ShiroRole)表实体类
 *
 * @author lzqwn
 * @since 2021-07-14 17:18:26
 */
@Data
@SuppressWarnings("serial")
public class ShiroRole extends Model<ShiroRole> {
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 角色名
     */
    private String name;
    /**
     * 描述
     */
    private String description;
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