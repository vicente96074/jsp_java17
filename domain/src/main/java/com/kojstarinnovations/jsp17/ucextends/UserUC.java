package com.kojstarinnovations.jsp17.ucextends;

import com.kojstarinnovations.jps17.ports.input.UseCase;
import com.kojstarinnovations.jps17.data.request.UserRequest;
import com.kojstarinnovations.jps17.data.response.UserResponse;

/**
 * Interface for use case of User
 *
 * @author Augusto Vicente
 */
public interface UserUC extends UseCase<UserRequest, UserResponse, Integer>{

    /**
     * Evaluate if the entity exists by username
     *
     * @param username of the object to be checked
     * @return boolean
     */
    boolean existsByUsername(String username);

    /**
     * Evaluate if the entity exists by email
     *
     * @param email of the object to be checked
     * @return boolean
     */
    boolean existsByEmail(String email);
}
