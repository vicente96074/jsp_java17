package com.kojstarinnovations.jps17.data.validators;

import com.kojstarinnovations.jps17.data.request.UserRequest;
import com.kojstarinnovations.jps17.exception.InvalidDataException;

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
