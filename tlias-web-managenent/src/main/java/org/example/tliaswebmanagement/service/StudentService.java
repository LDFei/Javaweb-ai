package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.pojo.Student;
import org.example.tliaswebmanagement.pojo.StudentQueryParam;

public interface StudentService {
    PageResult<Student> list(StudentQueryParam studentQueryParam);
}
