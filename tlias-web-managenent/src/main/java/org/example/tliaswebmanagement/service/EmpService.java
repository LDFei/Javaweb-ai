package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.Emp;
import org.example.tliaswebmanagement.pojo.EmpQueryParam;
import org.example.tliaswebmanagement.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {
    /*分页查询接口*/
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);
}
