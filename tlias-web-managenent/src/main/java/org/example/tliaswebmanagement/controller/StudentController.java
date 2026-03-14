package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.*;
import org.example.tliaswebmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public Result student_find_all(StudentQueryParam studentQueryParam)
    {
        log.info("查询学生人数接口");
        PageResult<org.example.tliaswebmanagement.pojo.Student> pageResult = studentService.list(studentQueryParam);
        return Result.success(pageResult);
    }

    @DeleteMapping("/{ids}")
    public Result student_delete(@PathVariable List<Integer> ids)
    {

        log.info("学生删除接口");
        studentService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Student student)
    {
        log.info("新增学生 :{}",student);
        studentService.save(student);
        return Result.success();
    }

}
