package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.example.tliaswebmanagement.pojo.Emp;
import org.example.tliaswebmanagement.pojo.EmpQueryParam;

import java.time.LocalDate;
import java.util.List;

/*
* 员工信息
* */
@Mapper
public interface EmpMapper {


    /*————————————————————————————————————————————原始分页的查询方式—————————————————————————————————————*/
//    /*查询总记录数*/
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
//    public Long count();

    /*查询工作人员信息*/
//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id " +
//            "order by e.update_time desc limit #{start},#{pageSize}")
//    public List<Emp> list(Integer start,Integer pageSize);
    //@Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id " +
            //"order by e.update_time desc")


////
//public List<Emp> list(String name, Integer gender,
////                          LocalDate begin, LocalDate end);
    public List<Emp> list (EmpQueryParam empQueryParam);
//新增员工基本信息
    @Options(useGeneratedKeys = true,keyProperty = "id")//获取到生成的主键--mybites主键返回
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)\n" +
            "    values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);
}
