package com.lzqwn.shiro.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzqwn.shiro.entity.ShiroUser;
import com.lzqwn.shiro.service.ShiroUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户表(ShiroUser)表控制层
 *
 * @author lzqwn
 * @since 2021-07-14 16:43:07
 */
@RestController
@RequestMapping("shiroUser")
public class ShiroUserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ShiroUserService shiroUserService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param shiroUser 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ShiroUser> page, ShiroUser shiroUser) {
        return success(this.shiroUserService.page(page, new QueryWrapper<>(shiroUser)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.shiroUserService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param shiroUser 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ShiroUser shiroUser) {
        return success(this.shiroUserService.save(shiroUser));
    }

    /**
     * 修改数据
     *
     * @param shiroUser 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ShiroUser shiroUser) {
        return success(this.shiroUserService.updateById(shiroUser));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.shiroUserService.removeByIds(idList));
    }
}