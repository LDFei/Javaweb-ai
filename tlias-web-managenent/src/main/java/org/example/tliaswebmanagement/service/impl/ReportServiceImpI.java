package org.example.tliaswebmanagement.service.impl;

import org.example.tliaswebmanagement.mapper.EmpMapper;
import org.example.tliaswebmanagement.pojo.JobOption;
import org.example.tliaswebmanagement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ReportServiceImpI implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public JobOption getEmpJobData() {
        //第一步调用mapper层
        List<Map<String, Object>> list = empMapper.countEmpJobData();

        //第二步把数组封装到对象里面
        List<Object> JobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> DataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new JobOption(JobList,DataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }


}
