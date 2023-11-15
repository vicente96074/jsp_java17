package com.kojstarinnovations.conjava17.domain.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Interface for the controller handler
 *
 * @author Augusto Vicente
 */
public interface ControllerHandler {

    /**
     * Method to handle the request and response for the controller
     *
     * @param request  the request
     * @param response the response
     * @throws ServletException The servlet exception
     * @throws IOException The io exception
     */
    void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    /**
     * Method to handle the request and response for the controller
     *
     * @param request  the request
     * @param response the response
     * @throws ServletException The servlet exception
     * @throws IOException The io exception
     */
    void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    /**
     * Method to handle the request and response for the controller
     *
     * @param request  the request
     * @param response the response
     * @throws ServletException The servlet exception
     * @throws IOException The io exception
     */
    void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    /**
     * Method to handle the request and response for the controller
     *
     * @param request  the request
     * @param response the response
     * @throws ServletException The servlet exception
     * @throws IOException The io exception
     */
    void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
