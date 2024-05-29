package com.rolling.controller;

import com.rolling.anno.Log;
import com.rolling.mapper.DeptMapper;
import com.rolling.pojo.Dept;
import com.rolling.pojo.Result;
import com.rolling.service.DeptService;
import com.rolling.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptCotroller {
    @Autowired
    private DeptService deptService;


    @GetMapping
    public Result deptCotroller() {
        log.info("查找全部部门信息");
        List<Dept> depts = deptService.list();
        return Result.success(depts);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门信息:{}", id);
        deptService.delete(id);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门信息:{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result find(@PathVariable Integer id) {
        log.info("查询id部门:{}", id);
        Dept dept = deptService.find(id);
        return Result.success(dept);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("更新部门名称:{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
