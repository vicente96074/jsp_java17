package com.kojstarinnovations.jsp17.adapters.input.controller;

import com.kojstarinnovations.jsp17.adapters.output.persistence.adapters.UserPA;
import com.kojstarinnovations.jsp17.connection.CustomizedConnection;
import com.kojstarinnovations.jsp17.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Rest controller for the user entity
 *
 * @author Augusto Vicente
 */
@WebServlet("/user")
public class UserController extends HttpServlet {

    /**
     * Method to handle the verb GET for the user entity
     *
     * @param req the request
     * @param resp the response
     * @throws ServletException The servlet exception
     * @throws IOException The io exception
     */
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        this.userService = UserService.getInstance(UserPA.getInstance(getConnection(session)));
        this.userService.doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        this.userService = UserService.getInstance(UserPA.getInstance(getConnection(session)));
        this.userService.doPost(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        this.userService = UserService.getInstance(UserPA.getInstance(getConnection(session)));
        this.userService.doPut(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        this.userService = UserService.getInstance(UserPA.getInstance(getConnection(session)));
        this.userService.doDelete(req, resp);
    }

    private Connection getConnection(HttpSession session) throws SQLException, IOException, ClassNotFoundException {

        if(session.getAttribute("connection") == null){
            session.setAttribute("connection", CustomizedConnection.getInstance().getConnection());
        }

        return (Connection) session.getAttribute("connection");
    }

    private UserService userService;
    private static Connection connection;
}
