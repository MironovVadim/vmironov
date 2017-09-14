package ru.job4j.todolist.servlets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import ru.job4j.controller.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Test class.
 */
@RunWith(PowerMockRunner.class)
public class AddServletTest {
    /**
     * Test doGet Method.
     * @throws ServletException - test.
     * @throws IOException - test.
     */
    @Test
    public void whenInvokeDoGetThenGetJSONString() throws ServletException, IOException {
        AddServlet servlet = new AddServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        DBService service = mock(DBService.class);
        Whitebox.setInternalState(service.getClass(), "service", service);

        servlet.doGet(req, resp);

        verify(service).getTasks();
    }
}
