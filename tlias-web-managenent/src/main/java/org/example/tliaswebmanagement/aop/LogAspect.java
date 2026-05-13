package org.example.tliaswebmanagement.aop;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.tliaswebmanagement.mapper.OperateLogMapper;
import org.example.tliaswebmanagement.pojo.OperateLog;
import org.example.tliaswebmanagement.utils.CurrentHolder;
import org.example.tliaswebmanagement.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect // 声明为切面类
public class LogAspect {

    @Autowired
    private HttpServletRequest request; // 自动注入请求对象，用于获取Header中的token

    @Autowired
    private OperateLogMapper operateLogMapper;

    // 环绕通知：切点表达式指向 controller 包下的所有方法
    @Around("@annotation(org.example.tliaswebmanagement.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

        // 1. 获取操作人ID (从threadlocal里面获取)
        String jwt = request.getHeader("token");
        Integer operateEmpId = CurrentHolder.getCurrentId();

        // 2. 获取操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        // 3. 获取目标类名和方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        // 4. 获取方法运行参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args); // 也可以用 JSON.toJSONString(args) 更清晰

        // 记录起始时间
        long begin = System.currentTimeMillis();

        // 5. 调用原始方法运行
        Object result = joinPoint.proceed();

        // 记录结束时间，计算耗时
        long end = System.currentTimeMillis();
        Long costTime = end - begin;

        // 6. 获取返回值 (转为JSON字符串存储)
        String returnValue = JSONObject.toJSONString(result);

        // 7. 封装日志对象
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(operateEmpId);
        operateLog.setOperateTime(operateTime);
        operateLog.setClassName(className);
        operateLog.setMethodName(methodName);
        operateLog.setMethodParams(methodParams);
        operateLog.setReturnValue(returnValue);
        operateLog.setCostTime(costTime);

        // 8. 调用 Mapper 插入数据
        operateLogMapper.insert(operateLog);

        log.info("AOP日志记录成功: {}", operateLog);

        return result;
    }
}