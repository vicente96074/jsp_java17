package com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.rest;

import com.kojstarinnovations.conjava17.domain.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Connection connection = (Connection) session.getAttribute("connection");
        this.userService = UserService.getInstance(connection);
        this.userService.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Connection connection = (Connection) session.getAttribute("connection");

        Logger.getLogger("UserController").log(Level.INFO, "Connection: {0}", connection);

        this.userService = UserService.getInstance(connection);
        this.userService.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Connection connection = (Connection) session.getAttribute("connection");
        this.userService = UserService.getInstance(connection);
        this.userService.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Connection connection = (Connection) session.getAttribute("connection");
        this.userService = UserService.getInstance(connection);
        this.userService.doDelete(req, resp);
    }

    private UserService userService;
}
