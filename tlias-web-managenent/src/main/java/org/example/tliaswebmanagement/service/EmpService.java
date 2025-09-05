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
}
