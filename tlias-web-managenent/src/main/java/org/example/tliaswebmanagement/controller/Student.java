package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.*;
import org.example.tliaswebmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController

public class Student {
    @Autowired
    private StudentService studentService;
    @GetMapping("/students")
    public Result student_find_all(StudentQueryParam studentQueryParam)
    {
        log.info("查询学生人数接口");
        PageResult<org.example.tliaswebmanagement.pojo.Student> pageResult =  studentService.list(studentQueryParam);
        return Result.success(pageResult);
    }
}
