package org.example.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.tliaswebmanagement.mapper.EmpExprMapper;
import org.example.tliaswebmanagement.mapper.EmpLogMapper;
import org.example.tliaswebmanagement.mapper.EmpMapper;
import org.example.tliaswebmanagement.pojo.*;
import org.example.tliaswebmanagement.service.EmpLogService;
import org.example.tliaswebmanagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;
    /*————————————————————————————————————————————————————原始分页查询的实现代码——————————————————————————————————-*/
//    @Override
    //如果要给传递过来的数据设置默认值，用requestparam(de = "1")这种加到传进的参数前面
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        Long total = empMapper.count();
//        Integer start = (page - 1) * pageSize;
//        List<Emp> rows =  empMapper.list(start,pageSize);
//
//        return new PageResult<Emp>(total,rows);
//    }

    /*基于pagehelper实现分页条件查询*/
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize,String name, Integer gender,
//                                LocalDate begin, LocalDate end) {
//
//        PageHelper.startPage(page,pageSize);
//        List<Emp> empList = empMapper.list(name, gender, begin, end);
//        Page<Emp> p = (Page<Emp>)empList;
//
//        return new PageResult<Emp>(p.getTotal(), p.getResult());
//    }

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {

        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPagesize());

        Page<Emp> p = (Page<Emp>) empMapper.list(empQueryParam);

        return  new PageResult<Emp>(p.getTotal(),p.getResult());
    }

    //插入员工的基本信息
    @Transactional(rollbackFor = {Exception.class}) //事务管理注解 - 默认出现运行时异常会出现回滚，添加了括号里面的代码有异常就会回滚
    @Override
    public void save(Emp emp) {
        try {
            //保存员工的基本信息
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);

            //int i = 1/0;
            //员工的工作经历信息
            List<EmpExpr> exprList = emp.getExprList();
            //判断工作经历是否为空：
            if(!CollectionUtils.isEmpty(exprList))
            {
                //遍历集合为empid赋值,
                exprList.forEach(empExpr->{
                    empExpr.setEmpId(emp.getId());
                });
                empExprMapper.insetBatch(exprList);
            }
            else
            {
                return;
            }
        } finally {
            //记录操作日志
            EmpLog empLog = new EmpLog(null,LocalDateTime.now(),"新增员工：" + emp);
            empLogService.insertLog(empLog);
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids) {
        //删除员工的基本信息
        empMapper.deleteByIds(ids);

        //删除员工工作经历信息:
        empExprMapper.deleteByEmpIds(ids);
    }

    //回显员工的工作经历
    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id);

    }

    //修改员工信息(这有bug，因为修改员工基本信息后端修改员工工作经历是在一个事务内，所以如果你不修改员工的工作经历，那么员工的基本信息也更改不了):
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void upDate(Emp emp) {
        //1.需要根据id修改员工的基本信息：
        emp.setUpdateTime(LocalDateTime.now());//先写更新信息的时间
        empMapper.updateById(emp);

        //2.根据id修改员工的工作经历信息：
        //2.1先删除员工的工作经历：
        //真是日了之前引用错方法了引用了员工基本信息删除的方法，结果特么调用一次如果工作经历不改
        //就删掉基本信息，我还纳闷前端怎么改一下数据库少个记录，bug在这呢fuck
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));

        //2.2后添加员工的工作经历：
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            //这段的代码逻辑是这样，把这个员工的经历删了之后，前端接收到的数据没有id值，
            //我需要先把这每段的id值给重新复写一下，然后再插入进去
            exprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));//为每一段工作经历赋值，赋员工id的值

            empExprMapper.insetBatch(exprList);
        }

    }




}
