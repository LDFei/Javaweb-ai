package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.example.tliaswebmanagement.pojo.Student;
import org.example.tliaswebmanagement.pojo.StudentQueryParam;

import java.util.List;

@Mapper
public interface StudentMapper {
     List<Student> list (StudentQueryParam classQueryParam);

    void delete(List<Integer> ids);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("INSERT INTO student(name,no,gender,phone,id_card,is_college,address,degree,graduation_date,clazz_id)" +
            "VALUES (#{name},#{no},#{gender},#{phone},#{idCard},#{isCollege},#{address},#{degree},#{graduationDate},#{clazzId})")
    void save(Student student);
}
