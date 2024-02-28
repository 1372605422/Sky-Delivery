package com.sky.service;


import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

import java.util.List;

public interface SetmealService {
    SetmealVO getById(Long id);


    void setMeal(SetmealDTO setmealDTO);

    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    void deleteBatches(List<Long> ids);

    void update(SetmealDTO setmealDTO);

    void changeStatus(Integer status, Long id);
}
