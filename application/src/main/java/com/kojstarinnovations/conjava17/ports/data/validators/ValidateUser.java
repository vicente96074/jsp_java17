package com.kojstarinnovations.conjava17.ports.data.validators;

import com.kojstarinnovations.conjava17.ports.data.request.UserRequest;
import com.kojstarinnovations.conjava17.ports.exception.InvalidDataException;

public class ValidateUser {

    /**
     * Method to validate a user request
     *
     * @param userRequest the user request to be validated
     * @throws InvalidDataException     if the data is invalid
     * @throws IllegalArgumentException if the user request is null
     */
    public static void validateUser(UserRequest userRequest) throws InvalidDataException, IllegalArgumentException {

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

    }
}
