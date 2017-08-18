package ru.job4j.servlets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class.
 */
@RunWith(PowerMockRunner.class)
public class AddingServiceUserServletTest {
    /**
     * Test servlet.
     * @throws ServletException - Servlet Exception.
     * @throws IOException - IO Exception.
     */
    @Test
    public void whenAddNewUserThenGetThisUser() throws ServletException, IOException {
        AddingServiceUserServlet servlet = new AddingServiceUserServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        Service controller = mock(Service.class);
        ServiceUser user = new ServiceUser("Vadim", "pass", "Administrator");
        Whitebox.setInternalState(servlet.getClass(), "controller", controller);
        List<ServiceUser> list = new ArrayList<>();
        list.add(user);

        when(req.getParameter("login")).thenReturn(user.getLogin());
        when(req.getParameter("password")).thenReturn(user.getPassword());
        when(req.getParameter("role")).thenReturn(user.getRole());
        when(controller.getServiceUsers()).thenReturn(list);

        servlet.doPost(req, resp);

        boolean result = controller.getServiceUsers().contains(user);
        boolean expected = true;

        verify(controller).addNewUser(user.getLogin(), user.getPassword(), user.getRole());
        assertThat(result, is(expected));
    }
}