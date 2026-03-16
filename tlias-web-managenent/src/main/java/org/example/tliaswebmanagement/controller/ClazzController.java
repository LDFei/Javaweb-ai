package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.*;
import org.example.tliaswebmanagement.pojo.Class;
import org.example.tliaswebmanagement.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RequestMapping("/clazzs")
@RestController
@Slf4j
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result ClazzPage(ClassQueryParam classQueryParam) {
            log.info("班级的分页查询：{}", classQueryParam);
            PageResult<Class> pageResult =  clazzService.page(classQueryParam);
            return Result.success(pageResult);
    }

    @GetMapping("/list")
    public Result list()
    {
        log.info("查询所有班级");

        List<Class> clazz = clazzService.list();

        return Result.success(clazz);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id)
    {
        log.info("班级删除功能");

        clazzService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Class clazz)
    {
        log.info("班级新增功能,新增数据为:{}",clazz);

        clazzService.save(clazz);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Class clazz)
    {
        log.info("修改班级信息");

        clazzService.update(clazz);
        return Result.success();
    }

    @GetMapping("{id}")
    public Result findById(@PathVariable Integer id)
    {
        log.info("班级修改功能数据回显：{}",id);
        Class clazz = clazzService.findById(id);
        return Result.success(clazz);
    }

}
