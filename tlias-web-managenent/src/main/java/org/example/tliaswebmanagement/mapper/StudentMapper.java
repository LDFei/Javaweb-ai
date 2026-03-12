package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.pojo.Student;
import org.example.tliaswebmanagement.pojo.StudentQueryParam;

import java.util.List;

@Mapper
public interface StudentMapper {
     List<Student> list (StudentQueryParam classQueryParam);
}
