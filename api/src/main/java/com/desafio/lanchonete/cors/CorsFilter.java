package com.desafio.lanchonete.cors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.setHeader("Access-Control-Allow-Credentials", "true");


        if("OPTIONS".equals(req.getMethod()) && "http://localhost:4200".equals(req.getHeader("Origin"))){
            resp.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT,OPTIONS");
            resp.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
            resp.setHeader("Access-Control-Max-Age", "3600");


            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
