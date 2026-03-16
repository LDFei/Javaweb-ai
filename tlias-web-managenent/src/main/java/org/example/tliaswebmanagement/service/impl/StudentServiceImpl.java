package org.example.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.tliaswebmanagement.mapper.StudentMapper;
import org.example.tliaswebmanagement.pojo.*;
import org.example.tliaswebmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public PageResult<Student> list (StudentQueryParam studentQueryParam) {

        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPagesize());

        Page<Student> p = (Page<Student>) studentMapper.list(studentQueryParam);

        return new PageResult<>(p.getTotal(),p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        studentMapper.delete(ids);
    }

    @Override
    public void save(Student student) {
        studentMapper.save(student);
    }

    @Override
    public Student findById(Integer id) {
        Student student = studentMapper.findById(id);
        return student;
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void score(Integer id, Integer score) {
        studentMapper.score(id,score);
    }
}
