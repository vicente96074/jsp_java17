package com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.data.validators;

import com.kojstarinnovations.conjava17.domain.exception.InvalidDataException;
import com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.data.request.UserRequest;

public class ValidateUser {

    /**
     * Method to validate a user request
     *
     * @param userRequest the user request to be validated
     * @return boolean
     * @throws InvalidDataException if the data is invalid
     * @throws IllegalArgumentException if the user request is null
     */
    public static boolean validateUser(UserRequest userRequest) throws InvalidDataException, IllegalArgumentException {

        if(userRequest == null){
            throw new IllegalArgumentException("UserRequest cannot be null");
        }

        if(userRequest.getUsername() == null || userRequest.getUsername().isEmpty()){
            throw new InvalidDataException("Username cannot be null or empty");
        }

        if(userRequest.getEmail() == null || userRequest.getEmail().isEmpty()){
            throw new InvalidDataException("Email cannot be null or empty");
        }

        if(userRequest.getPassword() == null || userRequest.getPassword().isEmpty()){
            throw new InvalidDataException("Password cannot be null or empty");
        }

        return true;
    }
}
