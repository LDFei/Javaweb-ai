package org.example.tliaswebmanagement.mapper;

/*
* 员工工作经验
* */

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.pojo.EmpExpr;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    //批量保存员工工作经历
    void insetBatch(List<EmpExpr> exprList);
}
