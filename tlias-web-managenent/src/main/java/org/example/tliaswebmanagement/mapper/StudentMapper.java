package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.*;
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

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student findById(Integer id);


    @Update("UPDATE student SET name = #{name}, no = #{no}, phone = #{phone}, " +
            "gender = #{gender}, degree = #{degree}, id_card = #{idCard}, " +
            "is_college = #{isCollege}, address = #{address}, " +
            "graduation_date = #{graduationDate}, violation_count = #{violationCount}, " +
            "violation_Score = #{violationScore}, clazz_id = #{clazzId}" +
            " WHERE id = #{id}"
            )
    void update(Student student);


    void score(Integer id, Integer score);
}
