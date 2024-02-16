package com.kojstarinnovations.jsp17.adapters.output.persistence.repository;


import com.kojstarinnovations.jsp17.adapters.output.persistence.entity.User;

import java.util.Optional;

/**
 * Repository interface for User
 *
 * @author Augusto Vicente
 */
public interface UserRepository extends Repository<User, Integer>, ResultSetHandler<User> {

    /**
     * Method to find out if a user exists by username
     *
     * @param username the username to be checked
     * @return boolean true if exists otherwise false
     */
    boolean existsByUsername(String username);

    /**
     * Method to find out if a user exists by email
     *
     * @param email the email to be checked
     * @return boolean true if exists otherwise false
     */
    boolean existsByEmail(String email);

    /**
     * Method to get a user by username
     *
     * @param username the username of the user to be retrieved
     * @return user with the given username
     */
    Optional<User> findByUsernameOrEmail(String username, String email);
}
