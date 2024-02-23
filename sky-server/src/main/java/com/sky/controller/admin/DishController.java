package com.sky.controller.admin;

import com.sky.annotation.AutoFill;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜品管理
 */
@RestController
@RequestMapping("/admin/dish")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;
    /**
     * 新增菜品
     * @param dishDTO
     * @return
     */
    @PostMapping
    public Result save(@RequestBody DishDTO dishDTO){
        log.info("新增菜品,{}",dishDTO);
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }

    /**
     * 分页查询菜品
     * @param dishPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO){
        log.info("菜品分页查询,{}",dishPageQueryDTO);
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 菜品
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Long> ids){
        dishService.deleteBatch(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<DishVO> getById(@PathVariable Long id){
        log.info("根据ID查询菜品，{}",id);
        DishVO dishVO = dishService.getByIdWithFlavor(id);
        return Result.success(dishVO);
    }
    @PutMapping
    public Result update(@RequestBody DishDTO dishDTO){
        log.info("修改菜品,{}",dishDTO);
        dishService.updateWithFlavor(dishDTO);
        return Result.success();
    }
}
