package com.lzqwn.shiro.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzqwn.shiro.entity.ShiroPermission;
import com.lzqwn.shiro.service.ShiroPermissionService;
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
 * 权限表(ShiroPermission)表控制层
 *
 * @author lzqwn
 * @since 2021-07-14 16:19:34
 */
@RestController
@RequestMapping("shiroPermission")
public class ShiroPermissionController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ShiroPermissionService shiroPermissionService;

    /**
     * 分页查询所有数据
     *
     * @param page            分页对象
     * @param shiroPermission 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ShiroPermission> page, ShiroPermission shiroPermission) {
        return success(this.shiroPermissionService.page(page, new QueryWrapper<>(shiroPermission)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.shiroPermissionService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param shiroPermission 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ShiroPermission shiroPermission) {
        return success(this.shiroPermissionService.save(shiroPermission));
    }

    /**
     * 修改数据
     *
     * @param shiroPermission 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ShiroPermission shiroPermission) {
        return success(this.shiroPermissionService.updateById(shiroPermission));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.shiroPermissionService.removeByIds(idList));
    }
}