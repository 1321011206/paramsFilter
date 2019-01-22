package com.monkey.paramsfilter.configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description:
 * @author: JJC
 * @createTime: 2019/1/22
 */
public class ParamsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ParameterRequestWrapper parmsRequest = new ParameterRequestWrapper((HttpServletRequest) servletRequest);
        filterChain.doFilter(parmsRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}

