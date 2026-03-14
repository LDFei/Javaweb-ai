package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.*;
import org.example.tliaswebmanagement.pojo.Class;

import java.util.List;

public interface ClazzService {
    PageResult<Class> page(ClassQueryParam empQueryParam);

    List<Class> list();
}
