package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.pojo.Class;
import org.example.tliaswebmanagement.pojo.ClassQueryParam;

import java.util.List;

@Mapper
public interface ClazzMapper {
    List<Class> list(ClassQueryParam classQueryParam);
}
