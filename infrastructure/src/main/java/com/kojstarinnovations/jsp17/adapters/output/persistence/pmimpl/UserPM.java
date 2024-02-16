package com.kojstarinnovations.jsp17.adapters.output.persistence.pmimpl;


import com.kojstarinnovations.jps17.pm.PersistenceMapper;
import com.kojstarinnovations.jsp17.adapters.output.persistence.entity.User;
import com.kojstarinnovations.jsp17.model.UserDto;

public class UserPM implements PersistenceMapper<User, UserDto> {
    /**
     * The method to convert DTO to ENTITY
     *
     * @param userDto is the data transfer object
     * @return the entity
     */
    @Override
    public User dtoToEntity(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCreatedAt(userDto.getCreatedAt());
        user.setUpdatedAt(userDto.getUpdatedAt());
        user.setElementStatus(userDto.getElementStatus());
        user.setCreatedBy(userDto.getCreatedBy());
        user.setUpdatedBy(userDto.getUpdatedBy());

        return user;
    }

    /**
     * The method to convert ENTITY to DTO
     *
     * @param user is the entity
     * @return the data transfer object
     */
    @Override
    public UserDto entityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setCreatedAt(user.getCreatedAt());
        userDto.setUpdatedAt(user.getUpdatedAt());
        userDto.setElementStatus(user.getElementStatus());
        userDto.setCreatedBy(user.getCreatedBy());
        userDto.setUpdatedBy(user.getUpdatedBy());

        return userDto;
    }

    //Singleton pattern
    private UserPM() {
    }

    /**
     * Method to get the instance
     *
     * @return the instance
     */
    public static UserPM getInstance() {
        if (instance == null) {
            instance = new UserPM();
        }
        return instance;

    }

    private static UserPM instance = null;
}
