package com.example.steel.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 登录认证Filter
 * 1.校验用户登录状态
 * 2.过期策略处理：活跃请求刷新redis过期时间
 * </p>
 *
 * @since 2019-06-26
 */
//此处使用FilterRegistrationConfig注册过滤器
@Slf4j
public class AuthFilter implements Filter {

    private static final String AUTH_FAILED_DISPATCH = "/authFailed";

    private static Long expireTime = 0L;

    private static final Set<String> FREE_FILTER_LIKE = new HashSet<String>();

    static {
        FREE_FILTER_LIKE.add("/user/index");
        FREE_FILTER_LIKE.add("/");
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("AuthFilter");
        //免过滤的url路径直接放行
        HttpServletRequest request = ((HttpServletRequest) servletRequest);
        String requestPath = request.getServletPath();
        for (String likePath : FREE_FILTER_LIKE) {
            if (requestPath.startsWith(likePath)){
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        String method = request.getMethod();
        String token = request.getHeader("token");
        if ("GET".equals(method) && StringUtils.isEmpty(token)){
            token = request.getParameter("token");
        }
        //不存在的token
        if (StringUtils.isEmpty(token)) {
            servletRequest.getRequestDispatcher(AUTH_FAILED_DISPATCH+"/null").forward(servletRequest, servletResponse);
        }
    }
}
