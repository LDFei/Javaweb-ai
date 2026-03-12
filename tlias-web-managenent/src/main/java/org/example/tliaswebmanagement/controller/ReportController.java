package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.JobOption;
import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;
    //统计各职位工作人数
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("统计各职位工作人数");
        JobOption jobOption =  reportService.getEmpJobData();
        return Result.success(jobOption);
    }
    //统计员工性别数量
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        log.info("统计员工性别数量");
        List<Map<String, Object>> jobOption = reportService.getEmpGenderData();
        return Result.success(jobOption);
    }

}
