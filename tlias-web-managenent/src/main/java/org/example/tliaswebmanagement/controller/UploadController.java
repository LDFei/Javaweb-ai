package org.example.tliaswebmanagement.controller;

import cn.hutool.core.lang.UUID;
import com.aliyun.oss.OSSClient;
import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.Result;

import org.example.tliaswebmanagement.utils.AliyunOSSOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
public class UploadController {

    /*本地磁盘存储方案*/
//    @PostMapping("/upload")
//    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
//        log.info("接收到的数据:{},{},{}",name,age,file);
//
//        String originalFilename = file.getOriginalFilename();
//
//        String newFileName = UUID.randomUUID().toString() + "." + originalFilename.substring(originalFilename.lastIndexOf("."));
//        file.transferTo(new File("D:/Program data/java-ai/" + newFileName));
//        return Result.success();
//    }
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("文件上传：{}" , file.getOriginalFilename());
        String url = aliyunOSSOperator.upload(file.getBytes(),file.getOriginalFilename());
        log.info("OSS返回的url:{}",url);
        return Result.success(url);
    }
}
