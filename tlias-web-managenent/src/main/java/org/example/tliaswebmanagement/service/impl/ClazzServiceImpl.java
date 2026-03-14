package org.example.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.tliaswebmanagement.mapper.ClazzMapper;
import org.example.tliaswebmanagement.pojo.Class;
import org.example.tliaswebmanagement.pojo.ClassQueryParam;
import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public PageResult<Class> page(ClassQueryParam classQueryParam) {
        PageHelper.startPage(classQueryParam.getPage(),classQueryParam.getPagesize());

        Page<Class> p = (Page<Class>) clazzMapper.list(classQueryParam);

        return new PageResult<Class>(p.getTotal(),p.getResult());
    }

    @Override
    public List<Class> list() {
        List<Class> clazz = clazzMapper.findall();

        return clazz;
    }
}
