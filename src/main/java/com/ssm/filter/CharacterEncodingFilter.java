package com.ssm.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * Created by hspcadmin on 2018/10/26.
 */
public class CharacterEncodingFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}
