package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.*;
import org.example.tliaswebmanagement.pojo.Class;
import org.example.tliaswebmanagement.pojo.ClassQueryParam;

import java.util.List;

@Mapper
public interface ClazzMapper {


    List<Class> list(ClassQueryParam classQueryParam);

    @Select("SELECT * FROM clazz")
    List<Class> findall();

    @Delete("DELETE FROM clazz c WHERE c.id = #{id}")
    void delete(Integer id);

    @Insert("INSERT INTO clazz (name,room,begin_date,end_date,master_id,subject)" +
            "VALUES (#{name},#{room},#{beginDate},#{endDate},#{masterId},#{subject})")
    void save(Class clazz);

    @Update("UPDATE clazz SET name = #{name}, room = #{room}, begin_date = #{beginDate}," +
            "end_date = #{endDate},master_id = #{masterId},subject = #{subject},update_time = #{updateTime}" +
            "Where id = #{id}")
    void update(Class clazz);

    @Select("SELECT * FROM clazz WHERE id = #{id}")
    Class finById(Integer id);
}
