package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.pojo.Student;
import org.example.tliaswebmanagement.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> list(StudentQueryParam studentQueryParam);

    void delete(List<Integer> ids);

    void save(Student student);
}
