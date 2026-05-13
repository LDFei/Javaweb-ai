package org.example.tliaswebmanagement.filter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
/*@WebFilter(urlPatterns = "/*")*/
@Slf4j
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("过滤器开始工作");
        // 放行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
