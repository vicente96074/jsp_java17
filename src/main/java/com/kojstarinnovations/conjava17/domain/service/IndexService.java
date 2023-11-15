package com.kojstarinnovations.conjava17.domain.service;

import com.kojstarinnovations.conjava17.domain.connection.CustomizedConnection;
import com.kojstarinnovations.conjava17.domain.exception.ConnectionException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Service to handle the index page
 *
 * @author Augusto Vicente
 */
public class IndexService {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ConnectionException The connection exception
     * @throws IOException The io exception
     */
    public void index(HttpServletRequest request, HttpServletResponse response) throws ConnectionException, IOException, ServletException {

        Logger.getLogger(IndexService.class.getName()).log(Level.INFO, "Index page requested");

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60 * 60 * 3); //3 hours

        try{
            session.setAttribute("connection", CustomizedConnection.getInstance().getConnection());
        }catch (IOException | ClassNotFoundException | SQLException ex){
            Logger.getLogger(IndexService.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            throw new ConnectionException("Error while connecting to the database");
        }

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    //Singleton pattern
    private IndexService() {
    }

    public static IndexService getInstance() {
        if (instance == null) {
            instance = new IndexService();
        }
        return instance;
    }

    private static IndexService instance;
}
