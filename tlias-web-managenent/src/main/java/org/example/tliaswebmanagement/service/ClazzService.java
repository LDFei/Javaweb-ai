package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.*;
import org.example.tliaswebmanagement.pojo.Class;

import java.util.List;

public interface ClazzService {
    PageResult<Class> page(ClassQueryParam empQueryParam);

    List<Class> list();

    void delete(Integer id);

    void save(Class clazz);

    void update(Class clazz);

    Class findById(Integer id);
}
