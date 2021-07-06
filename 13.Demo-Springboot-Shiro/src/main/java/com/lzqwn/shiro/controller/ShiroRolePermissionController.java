package com.lzqwn.shiro.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzqwn.shiro.entity.ShiroRolePermission;
import com.lzqwn.shiro.service.ShiroRolePermissionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 角色权限关系表(ShiroRolePermission)表控制层
 *
 * @author lzqwn
 * @since 2021-07-14 16:19:35
 */
@RestController
@RequestMapping("shiroRolePermission")
public class ShiroRolePermissionController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ShiroRolePermissionService shiroRolePermissionService;

    /**
     * 分页查询所有数据
     *
     * @param page                分页对象
     * @param shiroRolePermission 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ShiroRolePermission> page, ShiroRolePermission shiroRolePermission) {
        return success(this.shiroRolePermissionService.page(page, new QueryWrapper<>(shiroRolePermission)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.shiroRolePermissionService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param shiroRolePermission 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ShiroRolePermission shiroRolePermission) {
        return success(this.shiroRolePermissionService.save(shiroRolePermission));
    }

    /**
     * 修改数据
     *
     * @param shiroRolePermission 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ShiroRolePermission shiroRolePermission) {
        return success(this.shiroRolePermissionService.updateById(shiroRolePermission));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.shiroRolePermissionService.removeByIds(idList));
    }
}