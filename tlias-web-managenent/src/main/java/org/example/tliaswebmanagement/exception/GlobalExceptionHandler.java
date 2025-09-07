package org.example.tliaswebmanagement.exception;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result handlerException(Exception e)
    {
        log.error("程序出错辣：" ,e);
        return Result.error("出错辣，请联系管理员");
    }

    @ExceptionHandler
    public Result handleDuplicatekeyException(DuplicateKeyException e)
    {
        log.error("程序出错辣~",e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMsg = message.substring(i);
        String[] arr = errMsg.split(" ");
        return Result.error(arr[2] + "已存在，请确认你的信息");
    }
}
