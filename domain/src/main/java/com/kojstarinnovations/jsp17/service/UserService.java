package com.kojstarinnovations.jsp17.service;

import com.kojstarinnovations.jps17.exception.BadCredentialsException;
import com.kojstarinnovations.jps17.exception.DuplicatedException;
import com.kojstarinnovations.jps17.exception.NotFoundException;
import com.kojstarinnovations.jps17.ports.output.EventPublisher;
import com.kojstarinnovations.jps17.ports.output.event.EnrollingEvent;
import com.kojstarinnovations.jsp17.eventlistener.EventListenerAdapter;
import com.kojstarinnovations.jsp17.eventlistener.TransactionId;
import com.kojstarinnovations.jsp17.opextends.UserOP;
import com.kojstarinnovations.jps17.data.request.UserRequest;
import com.kojstarinnovations.jps17.data.response.UserResponse;
import com.kojstarinnovations.jps17.data.validators.ValidateUser;
import com.kojstarinnovations.jps17.enums.ElementStatus;
import com.kojstarinnovations.jsp17.dmimpl.UserDM;
import com.kojstarinnovations.jsp17.model.UserDto;
import com.kojstarinnovations.jsp17.ucextends.UserUC;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Service for the user entity
 *
 * @author Augusto Vicente
 */
public class UserService implements UserUC, ControllerHandler {

    /**
     * Save entity
     *
     * @param userRequest the entity to save
     * @return QueryResponse the saved entity
     */
    @SneakyThrows
    @Override
    public UserResponse save(UserRequest userRequest) {

        //Validate user otherwise throw exception
        ValidateUser.validateUser(userRequest);

        if(outputPort.existsByUsername(userRequest.getUsername())){
            throw new DuplicatedException("Username already exists");
        }

        if(outputPort.existsByEmail(userRequest.getEmail())){
            throw new DuplicatedException("Email already exists");
        }

        UserDto userDto = domainMapper.requestToDto(userRequest);
        userDto.setCreatedAt(LocalDateTime.now());
        userDto.setUpdatedAt(LocalDateTime.now());
        userDto.setCreatedBy("SYSTEM");
        userDto.setUpdatedBy("SYSTEM");
        userDto.setElementStatus(ElementStatus.NEW);

        userDto = outputPort.save(userDto);
        eventPublisher.handle(new EnrollingEvent<>("User created", LocalDateTime.now(), "UserService", "save", TransactionId.generateTransactionId(), userDto.getId()));

        return domainMapper.dtoToResponse(userDto);
    }

    /**
     * Delete entity by id
     *
     * @param integer the id of the entity to be deleted
     */
    @Override
    public void deleteById(Integer integer) {

    }

    /**
     * Evaluate if the entity exists by id
     *
     * @param integer id of the object to be checked
     * @return boolean
     */
    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    /**
     * Get all objects
     *
     * @param integer id of the object to be retrieved
     * @return QueryResponse
     */
    @Override
    public UserResponse getById(Integer integer) {
        return null;
    }

    /**
     * Update object by id
     *
     * @param createRequest the object to be updated
     * @param integer       id of the object to be updated
     * @return QueryResponse the updated object
     */
    @Override
    public UserResponse updateById(UserRequest createRequest, Integer integer) {
        return null;
    }

    /**
     * Evaluate if the entity exists by username
     *
     * @param username of the object to be checked
     * @return boolean
     */
    @Override
    public boolean existsByUsername(String username) {
        return false;
    }

    /**
     * Evaluate if the entity exists by email
     *
     * @param email of the object to be checked
     * @return boolean
     */
    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    /**
     * Method to handle the request and response for the controller
     *
     * @param request  the request
     * @param response the response
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger.getLogger("User Service").info("User Service called");

        UserResponse userResponse = (UserResponse) request.getSession().getAttribute("UserResponse");

        Logger.getLogger("User Service").info("UserResponse: " + userResponse);

        if(userResponse == null){
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            Logger.getLogger("User Service").info("User already logged in");
            request.getRequestDispatcher("user/profile.jsp").forward(request, response);
        }
    }

    /**
     * Method to handle the request and response for the controller
     *
     * @param request  the request
     * @param response the response
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger.getLogger("User Service").info("User Service called");

        String action = request.getParameter("action");
        switch (action){
            case "register" -> { //Register user
                UserRequest userRequest = (UserRequest) request.getSession().getAttribute("userRequest");
                UserResponse userResponse = save(userRequest);
                request.getSession().setAttribute("UserResponse", userResponse);
                request.getRequestDispatcher("user/profile.jsp").forward(request, response);
            }
            case "login" -> { //Login user
                try {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");

                    UserDto userDto = outputPort.loadUserByUsername(username);

                    //Validate password
                    if (!BCrypt.checkpw(password, userDto.getPassword())) {
                        throw new BadCredentialsException("Invalid credentials");
                    }

                    UserResponse userResponse = domainMapper.dtoToResponse(userDto);
                    request.getSession().setAttribute("UserResponse", userResponse);
                    request.getRequestDispatcher("user/profile.jsp").forward(request, response);

                    Logger.getLogger("User Service").info("User logged in");

                }catch (BadCredentialsException | NotFoundException ex){
                    request.setAttribute("error", ex.getMessage());
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    Logger.getLogger("User Service exception").log(Level.SEVERE, ex.getMessage());
                }
            }
            default -> //Default
                    request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    /**
     * Method to handle the request and response for the controller
     *
     * @param request  the request
     * @param response the response
     */
    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * Method to handle the request and response for the controller
     *
     * @param request  the request
     * @param response the response
     */
    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {

    }

    //Singleton pattern
    private UserService() {
        eventPublisher = EventListenerAdapter.getInstance();
        domainMapper = UserDM.getInstance();
    }

    public static UserService getInstance(UserOP outputPort) {
        if (instance == null) {
            UserService.outputPort = outputPort;
            instance = new UserService();
        }

        return instance;
    }

    private static UserService instance;
    private static UserOP outputPort;
    private final EventPublisher eventPublisher;
    private final UserDM domainMapper;
}
