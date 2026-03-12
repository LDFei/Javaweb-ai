package org.example.tliaswebmanagement.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
public class ClassQueryParam {
    private Integer page = 1;//页码
    private Integer pagesize = 10;//展示的记录数字
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;//开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;//结束时间

}