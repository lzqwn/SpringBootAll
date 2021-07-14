package com.lzqwn.shiro.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzqwn.shiro.entity.ShiroUserRole;
import com.lzqwn.shiro.service.ShiroUserRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户角色关系表(ShiroUserRole)表控制层
 *
 * @author lzqwn
 * @since 2021-07-14 17:18:26
 */
@RestController
@RequestMapping("shiroUserRole")
public class ShiroUserRoleController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ShiroUserRoleService shiroUserRoleService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param shiroUserRole 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ShiroUserRole> page, ShiroUserRole shiroUserRole) {
        return success(this.shiroUserRoleService.page(page, new QueryWrapper<>(shiroUserRole)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.shiroUserRoleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param shiroUserRole 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ShiroUserRole shiroUserRole) {
        return success(this.shiroUserRoleService.save(shiroUserRole));
    }

    /**
     * 修改数据
     *
     * @param shiroUserRole 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ShiroUserRole shiroUserRole) {
        return success(this.shiroUserRoleService.updateById(shiroUserRole));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.shiroUserRoleService.removeByIds(idList));
    }
}