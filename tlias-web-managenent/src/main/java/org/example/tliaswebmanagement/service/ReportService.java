package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.JobOption;
import org.example.tliaswebmanagement.pojo.StudentOption;

import java.util.List;
import java.util.Map;
public interface ReportService {

    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();

    List<Map<String, Integer>> getStudentDegreeDate();

    StudentOption getStudentcountData();
}
