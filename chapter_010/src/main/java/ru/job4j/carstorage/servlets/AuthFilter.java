package ru.job4j.carstorage.servlets;

import ru.job4j.controller.DBService;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter.
 */
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String requestURI = req.getRequestURI();
        if (session.getAttribute("id") != null && requestURI.matches(".*(login|signUp)\\.html$")) {
            resp.sendRedirect(String.format("%s/carstorage/carStorage.html", req.getContextPath()));
        } else if (requestURI.matches(".*(index\\.html|login\\.html|signUp\\.html|signIn|createUser|todolist\\.html|adding|complete|css|js)$")) {
            chain.doFilter(request, response);
        } else {
            if (session.getAttribute("id") == null) {
                resp.sendRedirect(String.format("%s/carstorage/login.html", req.getContextPath()));
                return;
            }
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        DBService.newInstance().closeFactory();
    }
}
