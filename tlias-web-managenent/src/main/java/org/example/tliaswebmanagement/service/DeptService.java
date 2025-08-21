package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.Dept;

import java.util.List;

public interface DeptService {

    public List<Dept> findAll();

    public void deleteById(Integer id);

    public void add(Dept dept);

    public Dept getById(Integer id);

    public void update(Dept dept);
}
