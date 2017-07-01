package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * Servlet.
 */
public class EchoServlet extends HttpServlet {
    /**
     * БД контроллер.
     */
    private DBController dbController;

    /**
     * Constructor.
     * @param dbController - контроллер БД
     */
    public EchoServlet(DBController dbController) {
        this.dbController = dbController;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));
        ResultSet resultSet = this.dbController.get(id);
        PrintWriter pw = new PrintWriter(resp.getOutputStream());
        try {
            while (resultSet.next()) {
                pw.append("name:" + resultSet.getString("name")
                        + " login: " + resultSet.getString("login")
                        + " email: " + resultSet.getString("email"));
                pw.flush();
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        this.dbController.post(name, login, email);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        this.dbController.put(email, name);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        this.dbController.delete(name);
    }

    /**
     * DBController Setter.
     * @param dbController - new DBController
     */
    public void setPostgresDbController(DBController dbController) {
        this.dbController = dbController;
    }
}
