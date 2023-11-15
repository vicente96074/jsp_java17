package com.kojstarinnovations.conjava17.domain.mapperimpl;

import com.kojstarinnovations.conjava17.domain.mapper.DomainMapper;
import com.kojstarinnovations.conjava17.domain.model.UserDto;
import com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.data.request.UserRequest;
import com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.data.response.UserResponse;

/**
 * Mapper for the user entity
 *
 * @author Augusto Vicente
 */
public class UserDM implements DomainMapper<UserDto, UserRequest, UserResponse> {


    /**
     * Method to convert a request to a dto
     *
     * @param userRequest
     * @return DTO
     */
    @Override
    public UserDto requestToDto(UserRequest userRequest) {
        UserDto userDto = new UserDto();
        userDto.setUsername(userRequest.getUsername());
        userDto.setEmail(userRequest.getEmail());
        userDto.setPassword(userRequest.getPassword());

        return userDto;
    }

    /**
     * Method to convert a dto to a response
     *
     * @param userDto
     * @return RESPONSE
     */
    @Override
    public UserResponse dtoToResponse(UserDto userDto) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(userDto.getUsername());
        userResponse.setEmail(userDto.getEmail());
        userResponse.setPassword(userDto.getPassword());
        userDto.setElementStatus(userDto.getElementStatus());

        return userResponse;
    }

    //Singleton pattern

    /**
     * Private constructor
     */
    private UserDM() {

    }

    /**
     * Method to get the instance
     *
     * @return UserDM
     */
    public static UserDM getInstance() {
        if(instance == null) {
            instance = new UserDM();
        }

        return instance;
    }

    private static UserDM instance = null;
}
