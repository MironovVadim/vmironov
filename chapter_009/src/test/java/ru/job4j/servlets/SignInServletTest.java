package ru.job4j.servlets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

/**
 * Test SignInServlet class.
 */
@RunWith(PowerMockRunner.class)
public class SignInServletTest {
    /**
     * Test doPost(HttpServletRequest, HttpServletResponse) method.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Test
    public void whenInvokeDoPostInvokesDoGet() throws ServletException, IOException {
        SignInServlet servlet = new SignInServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        Service service = mock(Service.class);
        Whitebox.setInternalState(servlet.getClass(), "controller", service);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        String login = "SomeLogin";
        String password = "pass";
        String path = "/WEB-INF/views/login.jsp";

        when(req.getParameter("login")).thenReturn(login);
        when(req.getParameter("password")).thenReturn(password);
        when(req.getRequestDispatcher(path)).thenReturn(dispatcher);
        when(service.checkServiceUser(login, password)).thenReturn(0);

        servlet.doPost(req, resp);

        verify(req).getRequestDispatcher(path);
    }

    /**
     * Test doPost(HttpServletRequest, HttpServletResponse) method.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Test
    public void whenInvokeDoPostThenInvokesGetSession() throws ServletException, IOException {
        SignInServlet servlet = new SignInServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        Service service = mock(Service.class);
        Whitebox.setInternalState(servlet.getClass(), "controller", service);
        HttpSession session = mock(HttpSession.class);

        String login = "SomeLogin";
        String password = "pass";
        int userId = 1;
        String role = "Administrator";

        when(req.getSession()).thenReturn(session);
        when(req.getParameter("login")).thenReturn(login);
        when(req.getParameter("password")).thenReturn(password);
        when(req.getContextPath()).thenReturn("path");
        when(service.checkServiceUser(login, password)).thenReturn(userId);
        when(service.getServiceRole(userId)).thenReturn(role);

        servlet.doPost(req, resp);

        verify(service).getServiceRole(userId);
        verify(req).getSession();
        verify(resp).sendRedirect(String.format("%s/", req.getContextPath()));
    }
}