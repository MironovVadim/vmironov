package ru.job4j.servlets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

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
@RunWith(PowerMockRunner.class)
@PrepareForTest({AddingServiceUserServlet.class})
public class AddingServiceUserServletTest {
    /**
     * Test servlet.
     * @throws ServletException - Servlet Exception.
     * @throws IOException - IO Exception.
     */
    @Test
    public void whenAddNewUserThenGetThisUser() throws ServletException, IOException {
        AddingServiceUserServlet servlet = PowerMockito.mock(AddingServiceUserServlet.class);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        ServiceDBController controller = Whitebox.getInternalState(servlet.getClass(), "controller");
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