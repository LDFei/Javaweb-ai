package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.*;
import org.example.tliaswebmanagement.pojo.Class;

public interface ClazzService {
    PageResult<Class> page(ClassQueryParam empQueryParam);
}
