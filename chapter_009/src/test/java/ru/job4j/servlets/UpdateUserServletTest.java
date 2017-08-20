package ru.job4j.servlets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test UpdateUserServlet class.
 */
@RunWith(PowerMockRunner.class)
public class UpdateUserServletTest {

    /**
     * Test doPost(HttpServletRequest, HttpServletResponse) method.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Test
    public void whenInvokeDoPostThenInvokesUpdateUserEmail() throws ServletException, IOException {
        UpdateUserServlet servlet = new UpdateUserServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        DBController controller = mock(DBController.class);
        Whitebox.setInternalState(servlet.getClass(), "dbController", controller);

        String email = "Some@gmail.com";
        String name = "SomeName";

        when(req.getParameter("email")).thenReturn(email);
        when(req.getParameter("name")).thenReturn(name);

        servlet.doPost(req, resp);

        verify(controller).put(email, name);

    }
}