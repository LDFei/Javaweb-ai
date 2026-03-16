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

    @GetMapping("{id}")
    public Result findById(@PathVariable Integer id)
    {
        log.info("根据Id查询对应的学生信息：{}",id);
        Student student = studentService.findById(id);
        return Result.success(student);
    }

    @PutMapping()
    public Result update(@RequestBody Student student)
    {
        log.info("更新{}学生数据",student);
        studentService.update(student);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result score(@PathVariable Integer id,
                        @PathVariable Integer score)
    {
        log.info("扣除{}学生{}分数:",id,score);
        studentService.score(id,score);
        return Result.success();
    }
}
