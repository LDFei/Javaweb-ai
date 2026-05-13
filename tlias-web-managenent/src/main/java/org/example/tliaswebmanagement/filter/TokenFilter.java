package org.example.tliaswebmanagement.filter;

import cn.hutool.http.server.HttpServerRequest;
import cn.hutool.http.server.HttpServerResponse;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.utils.CurrentHolder;
import org.example.tliaswebmanagement.utils.JwtUtils;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
@Slf4j
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        //1.获取请求路径
        String path = req.getServletPath();
        log.info("请求路径：{}", path);

        //2.判断是否为登录请求
        if("/login".equals(path))
        {
            log.info("登录请求");
            chain.doFilter(request, response);
            return;
        }

        // 获取请求头中的token
        String tooken = req.getHeader("token");

        // 3.判断token是否为空,如果为空则返回401错误
        if(tooken == null || tooken.isEmpty())
        {
            log.info("令牌未空，响应为410");
            res.setStatus(401);
            return;
        }

        // 4.验证令牌是否正确，不正确返回401错误
        try {
            Claims claims = JwtUtils.parseJWT(tooken);
            Integer id = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(id);
            log.info("当前用户id为：{},将其存入Threadlocal", id);

        }
        catch (Exception e){
            log.info("令牌非法，响应为410");
            res.setStatus(401);
            return;
        }

        // 5.放行
        chain.doFilter(request, response);
        log.info("过滤器开始工作");

        //删除对应的threadlocal的数据
        CurrentHolder.remove();
    }
}
