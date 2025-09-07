package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.Emp;
import org.example.tliaswebmanagement.pojo.EmpQueryParam;
import org.example.tliaswebmanagement.pojo.PageResult;

import java.util.List;

public interface EmpService {
    /*分页查询接口*/
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /*新增员工信息*/
    void save(Emp emp);

    //批量删除员工的信息
    void delete(List<Integer> ids);

    //回显员工的信息和工作经历
    Emp getInfo(Integer id);


    //修改员工信息：
    void upDate(Emp emp);
}
