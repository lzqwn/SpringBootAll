package com.lzqwn.shiro.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzqwn.shiro.entity.ShiroRole;
import com.lzqwn.shiro.service.ShiroRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 角色表(ShiroRole)表控制层
 *
 * @author lzqwn
 * @since 2021-07-14 16:43:07
 */
@RestController
@RequestMapping("shiroRole")
public class ShiroRoleController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ShiroRoleService shiroRoleService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param shiroRole 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ShiroRole> page, ShiroRole shiroRole) {
        return success(this.shiroRoleService.page(page, new QueryWrapper<>(shiroRole)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.shiroRoleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param shiroRole 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ShiroRole shiroRole) {
        return success(this.shiroRoleService.save(shiroRole));
    }

    /**
     * 修改数据
     *
     * @param shiroRole 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ShiroRole shiroRole) {
        return success(this.shiroRoleService.updateById(shiroRole));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.shiroRoleService.removeByIds(idList));
    }
}