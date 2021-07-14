package com.lzqwn.shiro.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 角色表(ShiroRole)表实体类
 *
 * @author lzqwn
 * @since 2021-07-14 16:43:07
 */
@Data
@SuppressWarnings("serial")
public class ShiroRole extends Model<ShiroRole> {
  @TableId(type = IdType.AUTO)
    /**主键*/
    private Long id;
    /**角色名*/
    private String name;
    /**描述*/
    private String description;
    /**创建时间*/
    private Long createTime;
    /**更新时间*/
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