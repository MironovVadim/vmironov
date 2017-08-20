package ru.job4j.servlets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;

/**
 * Test AuthFilter class.
 */
@RunWith(PowerMockRunner.class)
public class AuthFilterTest {
    /**
     * Test doFilter(ServletRequest, ServletResponse, FilterChain) method.
     * @throws IOException - IOException.
     * @throws ServletException - ServletException.
     */
    @Test
    public void whenDoFilterThenInvokeOnlyChainDoFilter() throws IOException, ServletException {
        AuthFilter filter = new AuthFilter();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class);

        when(req.getRequestURI()).thenReturn("/signIn");

        filter.doFilter(req, resp, chain);

        verify(chain).doFilter(req, resp);
        verify(req, never()).getSession();
    }

    /**
     * Test doFilter(ServletRequest, ServletResponse, FilterChain) method.
     * @throws IOException - IOException.
     * @throws ServletException - ServletException.
     */
    @Test
    public void whenDoFilterThenInvokeGetSessionAndRespSendRedirect() throws IOException, ServletException {
        AuthFilter filter = new AuthFilter();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class);
        HttpSession session = mock(HttpSession.class);

        String login = "login";

        when(req.getRequestURI()).thenReturn("");
        when(req.getSession()).thenReturn(session);
        when(session.getAttribute(login)).thenReturn(null);
        when(req.getContextPath()).thenReturn("path");

        filter.doFilter(req, resp, chain);

        verify(chain, never()).doFilter(req, resp);
        verify(req).getSession();
        verify(session).getAttribute(login);
        verify(resp).sendRedirect(String.format("%s/signIn", req.getContextPath()));
    }

    /**
     * Test doFilter(ServletRequest, ServletResponse, FilterChain) method.
     * @throws IOException - IOException.
     * @throws ServletException - ServletException.
     */
    @Test
    public void whenInvokeDoFilterThenInvokeGetSessionAndChainDoFilter() throws IOException, ServletException {
        AuthFilter filter = new AuthFilter();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class);
        HttpSession session = mock(HttpSession.class);

        String login = "login";

        when(req.getRequestURI()).thenReturn("");
        when(req.getSession()).thenReturn(session);
        when(session.getAttribute(login)).thenReturn(login);
        when(req.getContextPath()).thenReturn("path");

        filter.doFilter(req, resp, chain);

        verify(req).getSession();
        verify(resp, never()).sendRedirect(String.format("%s/signIn", req.getContextPath()));
        verify(chain).doFilter(req, resp);

    }
}