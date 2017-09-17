package ru.job4j.carstorage.servlets;

import javax.servlet.*;
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
        String requestURI = req.getRequestURI();
        if (requestURI.matches(".*(todolist.html|login.html|signUp.html|index.html|adding|complete|css|jpg|png|gif|js|)")) {
            chain.doFilter(req, resp);
        } else {
            HttpSession session = req.getSession();
            if (session.getAttribute("id") == null) {
                (resp).sendRedirect(String.format("/carstorage/login.html", req.getContextPath()));
                return;
            }
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
    }
}
