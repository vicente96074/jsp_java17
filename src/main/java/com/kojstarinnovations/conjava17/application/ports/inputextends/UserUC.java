package com.kojstarinnovations.conjava17.application.ports.inputextends;

import com.kojstarinnovations.conjava17.application.ports.input.UseCase;
import com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.data.request.UserRequest;
import com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.data.response.UserResponse;

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
