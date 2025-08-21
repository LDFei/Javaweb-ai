package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.*;
import org.example.tliaswebmanagement.pojo.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {

    //删除部门代码
    @Delete("delete from dept where id = #{id}")
    public void deleteById(Integer id);


    //查询所有的部门
    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    public List<Dept> finAll();


    //插入部门的代码
    @Insert("insert  into dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);


    //根据id查询部门的代码
    @Select("SELECT id, name, create_time, update_time from dept where id = #{id}")
    Dept getById(Integer id);

    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}