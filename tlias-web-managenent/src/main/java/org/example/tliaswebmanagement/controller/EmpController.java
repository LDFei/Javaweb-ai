package org.example.tliaswebmanagement.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.Emp;
import org.example.tliaswebmanagement.pojo.EmpQueryParam;
import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.DurationFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


/*
 *员工管理的接口
 * */


@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    /*这里的日期格式要注意和前端的参数的数据格式一致*/
    @GetMapping
    public Result page(EmpQueryParam empQueryParam)
    {
        log.info("分页查询：{}",empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }
    /*新增员工*/
    @PostMapping
    public Result save(@RequestBody Emp emp)//接收前端的json数据然后给我的对象里面的变量赋值，需要@RequestBody这个注解
    {
        log.info("新增员工:{}",emp);

        empService.save(emp);

        return Result.success();
    }


    /*删除员工*/
    //封装到数组中:
//    @DeleteMapping
//    public Result delete(Integer[] ids)
//    {
//        log.info("删除员工:{}", Arrays.toString(ids));//这里要把它变成字符串
//        return Result.success();
//    }

    //封装到一个list集合中:
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids)
    {
        log.info("删除员工：{}",ids);
        empService.delete(ids);
        return Result.success();
    }
}
