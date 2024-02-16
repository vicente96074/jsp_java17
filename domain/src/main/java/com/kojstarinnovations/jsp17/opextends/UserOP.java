package com.kojstarinnovations.jsp17.opextends;

import com.kojstarinnovations.jps17.exception.NotFoundException;
import com.kojstarinnovations.jps17.ports.output.OutputPort;
import com.kojstarinnovations.jsp17.model.UserDto;

/**
 * Output port for the user entity
 *
 * @author Augusto Vicente
 */
public interface UserOP extends OutputPort<UserDto, Integer> {

    /**
     * Method to evaluate if a user exists by username
     *
     * @param username the username to be checked
     * @return boolean
     */
    boolean existsByUsername(String username);

    /**
     * Method to evaluate if a user exists by email
     *
     * @param email the email to be checked
     * @return boolean
     */
    boolean existsByEmail(String email);

    /**
     * Method to get a user by username
     *
     * @param usernameOrEmail the username of the user to be retrieved
     * @return user with the given username
     */
    UserDto loadUserByUsername(String usernameOrEmail) throws NotFoundException;
}
