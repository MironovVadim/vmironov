package ru.job4j.servlets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

/**
 * Test DeleteUserServlet class.
 */
@RunWith(PowerMockRunner.class)
public class DeleteUserServletTest {

    /**
     * Test doPost(HttpServletRequest, HttpServletResponse) method.
     * @throws ServletException - ServletException.
     * @throws IOException - IOExce[ption.
     */
    @Test
    public void whenInvokeDoPostThenInvokesControllerDelete() throws ServletException, IOException {
        DeleteUserServlet servlet = new DeleteUserServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        DBController controller = mock(DBController.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        Whitebox.setInternalState(servlet.getClass(), "dbController", controller);

        String name = "SomeName";
        String path = "/WEB-INF/views/view.jsp";

        when(req.getParameter("name")).thenReturn(name);
        when(req.getRequestDispatcher(path)).thenReturn(dispatcher);

        servlet.doPost(req, resp);

        verify(controller).delete(name);
    }
}