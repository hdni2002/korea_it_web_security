package com.koreait.SpringSecurityStudy.security.Filter;

import java.io.IOException;
import jakarta.servlet.*;
public class JwtAuthenticationFilter implements Filter{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("전처리");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("후처리");

    }
}
