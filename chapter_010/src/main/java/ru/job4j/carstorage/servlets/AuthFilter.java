package ru.job4j.carstorage.servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String requestURI = req.getRequestURI();
        if (requestURI.contains("/login.html") || requestURI.contains("/signUp.html")) {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
