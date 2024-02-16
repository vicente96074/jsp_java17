package com.kojstarinnovations.jsp17.service;

import com.kojstarinnovations.jps17.exception.ConnectionException;
import com.kojstarinnovations.jsp17.connection.CustomizedConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
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

            if (connectedToDatabase(session)){
                Logger.getLogger("IndexService").info("Already has connection in session");
            }

            if (!connectedToDatabase(session)) {
                Logger.getLogger(IndexService.class.getName()).log(Level.INFO, "Creating database connection");
                session.setAttribute("connection", CustomizedConnection.getInstance().getConnection());
            }

            if(!isUserLogged(session)){
                Logger.getLogger(IndexService.class.getName()).log(Level.INFO, "User not logged");

                //Redirect to login.jsp if user is not logged
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else{
                Logger.getLogger(IndexService.class.getName()).log(Level.INFO, "User logged");

                //Redirect to profile.jsp if user is logged
                request.getRequestDispatcher("/user/profile.jsp").forward(request, response);
            }

        }catch (IOException | ClassNotFoundException | SQLException ex){
            Logger.getLogger(IndexService.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            throw new ConnectionException("Error while connecting to the database");
        }
    }

    private boolean connectedToDatabase(HttpSession session) {
        Connection connection = (Connection) session.getAttribute("connection");

        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(IndexService.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
    }

    private boolean isUserLogged(HttpSession session) {
        return session.getAttribute("UserResponse") != null;
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
