package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.example.tliaswebmanagement.pojo.Dept;
import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/depts")
@RestController
@Slf4j

/*
* 部门信息的接口
* */
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
        System.out.println("\n");
//        System.out.println("查询数据全部的信息");
        log.info("查询数据全部的信息");
        List<Dept> deptList = deptService.findAll();
        System.out.println("\n");
        return Result.success(deptList);

    }

    @DeleteMapping
    public Result delete(Integer id)
    {
        System.out.println("\n");
//        System.out.println("删除部门的id为:" + id);
        log.info("删除部门的id为:{}" , id);
        deptService.deleteById(id);
        System.out.println("\n");
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept)
    {
        System.out.println("\n");
//        System.out.println("添加的部门名称为: " + dept);
        log.info("删除部门的id为:{}" , dept);
        deptService.add(dept);
        System.out.println("\n");
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id)
    {
        System.out.println("\n");
//        System.out.println("查询的部门ID为: " + id);
        log.info("删除部门的id为:{}" , id);
        Dept dept = deptService.getById(id);
        System.out.println("\n");
        return Result.success(dept);
    }


    @PutMapping
    public Result update(@RequestBody Dept dept)
    {
        System.out.println("\n");
//        System.out.println("修改的部门为:" + dept);
        log.info("删除部门的id为:{}" , dept);
        deptService.update(dept);
        System.out.println("\n");
        return Result.success();
    }
}
