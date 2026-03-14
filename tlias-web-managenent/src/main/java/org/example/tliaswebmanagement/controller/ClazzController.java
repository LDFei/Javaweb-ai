package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.*;
import org.example.tliaswebmanagement.pojo.Class;
import org.example.tliaswebmanagement.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
