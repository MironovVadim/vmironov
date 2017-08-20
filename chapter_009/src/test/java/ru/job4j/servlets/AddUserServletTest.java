package ru.job4j.servlets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

/**
 * Test AddUserServletTest class.
 */
@RunWith(PowerMockRunner.class)
public class AddUserServletTest {
    /**
     * Test doPost(HttpServletRequest, HttpServletResponse) method.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Test
    public void whenAddNewUserThenGetThisUser() throws ServletException, IOException {
        AddUserServlet servlet = new AddUserServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        User user = new User("Vadim", "SomeLogin", "SomeMail@gmail.com", new Date());
        DBController controller = mock(DBController.class);
        Whitebox.setInternalState(servlet.getClass(), "dbController", controller);
        List<User> list = new ArrayList<>();
        list.add(user);

        when(req.getParameter("name")).thenReturn(user.getName());
        when(req.getParameter("login")).thenReturn(user.getLogin());
        when(req.getParameter("email")).thenReturn(user.getEmail());
        when(controller.get()).thenReturn(list);

        servlet.doPost(req, resp);

        boolean result = controller.get().contains(user);
        boolean expected = true;

        verify(controller).post(user.getName(), user.getLogin(), user.getEmail());
        assertThat(result, is(expected));
    }
}