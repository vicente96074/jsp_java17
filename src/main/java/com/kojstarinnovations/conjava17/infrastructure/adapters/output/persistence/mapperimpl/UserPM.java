package com.kojstarinnovations.conjava17.infrastructure.adapters.output.persistence.mapperimpl;

import com.kojstarinnovations.conjava17.domain.model.UserDto;
import com.kojstarinnovations.conjava17.infrastructure.adapters.output.persistence.entity.User;
import com.kojstarinnovations.conjava17.infrastructure.adapters.output.persistence.mapper.PersistenceMapper;

/**
 * Mapper for the user entity
 *
 * @author Augusto Vicente
 */
public class UserPM implements PersistenceMapper<User, UserDto> {
    /**
     * Method to map a DTO to an entity
     *
     * @param userDto the DTO to be mapped
     * @return the entity
     */
    @Override
    public User dtoToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCreatedAt(userDto.getCreatedAt());
        user.setUpdatedAt(userDto.getUpdatedAt());
        user.setCreatedBy(userDto.getCreatedBy());
        user.setUpdatedBy(userDto.getUpdatedBy());
        user.setElementStatus(userDto.getElementStatus());
        return user;
    }

    /**
     * Method to map an entity to a DTO
     *
     * @param user the entity to be mapped
     * @return the DTO
     */
    @Override
    public UserDto entityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setCreatedAt(user.getCreatedAt());
        userDto.setUpdatedAt(user.getUpdatedAt());
        userDto.setCreatedBy(user.getCreatedBy());
        userDto.setUpdatedBy(user.getUpdatedBy());
        userDto.setElementStatus(user.getElementStatus());
        return userDto;
    }

    //Singleton pattern

    /**
     * Private constructor
     */
    private UserPM(){

    }

    public static UserPM getInstance(){
        if(instance == null){
            instance = new UserPM();
        }
        return instance;
    }

    private static UserPM instance = null;
}
