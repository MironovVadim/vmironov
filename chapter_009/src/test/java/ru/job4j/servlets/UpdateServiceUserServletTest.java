package ru.job4j.servlets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

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
 * Test UpdateServiceUserServlet class.
 */
@RunWith(PowerMockRunner.class)
public class UpdateServiceUserServletTest {

    /**
     * Test doPost(HttpServletRequest, HttpServletResponse) method.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Test
    public void whenInvokeDoPostThenInvokesUpdateUserLoginAndPassword() throws ServletException, IOException {
        UpdateServiceUserServlet servlet = new UpdateServiceUserServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        Service service = mock(Service.class);
        HttpSession session = mock(HttpSession.class);
        Whitebox.setInternalState(servlet.getClass(), "controller", service);

        String currentLogin = "currentLogin";
        String newLogin = "newLogin";
        String newPassword = "newPass";
        String userRole = "User";

        when(session.getAttribute("login")).thenReturn(currentLogin);
        when(session.getAttribute("role")).thenReturn(userRole);
        when(req.getSession()).thenReturn(session);
        when(req.getParameter("newLogin")).thenReturn(newLogin);
        when(req.getParameter("password")).thenReturn(newPassword);

        servlet.doPost(req, resp);

        verify(service).updateServiceUserLogin(currentLogin, newLogin);
        verify(service).updateServiceUserPassword(newLogin, newPassword);
        verify(req, never()).getParameter("role");
    }

    /**
     * Test doPost(HttpServletRequest, HttpServletResponse) method.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Test
    public void whenInvokeDoPostThenInvokesUpdateAdministratorLoginAndPasswordAndRole() throws ServletException, IOException {
        UpdateServiceUserServlet servlet = new UpdateServiceUserServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        Service service = mock(Service.class);
        HttpSession session = mock(HttpSession.class);
        Whitebox.setInternalState(servlet.getClass(), "controller", service);

        String currentLogin = "currentLogin";
        String newLogin = "newLogin";
        String newPassword = "newPass";
        String administratorRole = "Administrator";
        String userRole = "User";

        when(session.getAttribute("login")).thenReturn(currentLogin);
        when(session.getAttribute("role")).thenReturn(administratorRole);
        when(req.getSession()).thenReturn(session);
        when(req.getParameter("login")).thenReturn(currentLogin);
        when(req.getParameter("newLogin")).thenReturn(newLogin);
        when(req.getParameter("password")).thenReturn(newPassword);
        when(req.getParameter("role")).thenReturn(userRole);

        servlet.doPost(req, resp);

        verify(service).updateServiceUserLogin(currentLogin, newLogin);
        verify(service).updateServiceUserPassword(newLogin, newPassword);
        verify(service).updateServiceUserRole(newLogin, userRole);
    }
}