package ru.job4j.servlets;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class.
 */
public class AddingServiceUserServletTest {
    /**
     * Test servlet.
     * @throws ServletException - Servlet Exception.
     * @throws IOException - IO Exception.
     */
    @Test
    public void addNewServiceUser() throws ServletException, IOException {
        AddingServiceUserServlet servlet = mock(AddingServiceUserServlet.class);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        ServiceDBController controller = mock(PostgresServiceDBController.class);
        ServiceUser user = new ServiceUser("Vadim", "pass", "Administrator");
        when(req.getParameter("login")).thenReturn(user.getLogin());
        when(req.getParameter("password")).thenReturn(user.getPassword());
        when(req.getParameter("role")).thenReturn(user.getRole());

        servlet.doPost(req, resp);

        boolean result = controller.getServiceUsers().contains(user);
        boolean expected = true;

        assertThat(result, is(expected));
    }
}