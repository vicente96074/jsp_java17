package com.kojstarinnovations.conjava17.infrastructure.adapters.output.persistence.adapters;

import com.kojstarinnovations.conjava17.application.ports.outputextends.UserOP;
import com.kojstarinnovations.conjava17.domain.exception.NotFoundException;
import com.kojstarinnovations.conjava17.domain.model.UserDto;
import com.kojstarinnovations.conjava17.infrastructure.adapters.output.persistence.entity.User;
import com.kojstarinnovations.conjava17.infrastructure.adapters.output.persistence.mapperimpl.UserPM;
import com.kojstarinnovations.conjava17.infrastructure.adapters.output.persistence.repository.UserRepository;
import com.kojstarinnovations.conjava17.infrastructure.adapters.output.persistence.repositoryimpl.UserRepositoryImpl;

import java.sql.Connection;
import java.util.Optional;

/**
 * Persistence adapter for the user entity
 *
 * @author Augusto Vicente
 */
public class UserPA implements UserOP {
    /**
     * Method to save a modelDto
     *
     * @param modelDto the modelDto to be saved
     * @return modelDto
     */
    @Override
    public UserDto save(UserDto modelDto) {
        return null;
    }

    /**
     * Method to get a modelDto by id
     *
     * @param integer the id of the modelDto to be retrieved
     * @return modelDto with the given id
     */
    @Override
    public Optional<UserDto> getById(Integer integer) {
        return Optional.empty();
    }

    /**
     * Method to update a modelDto by id
     *
     * @param modelDto the modelDto to be updated
     * @param integer  the id of the modelDto to be updated
     * @return modelDto updated
     */
    @Override
    public UserDto updateById(UserDto modelDto, Integer integer) {
        return null;
    }

    /**
     * Method to delete a model by id
     *
     * @param integer the id of the model to be deleted
     */
    @Override
    public void deleteById(Integer integer) {

    }

    /**
     * Method to evaluate if a model exists by id
     *
     * @param integer the id of the model to be evaluated
     * @return boolean
     */
    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    /**
     * Method to evaluate if a model exists by username
     *
     * @param username the username of the model to be evaluated
     * @return boolean
     */
    @Override
    public boolean existsByUsername(String username) {
        return false;
    }

    /**
     * Method to evaluate if a model exists by email
     *
     * @param email the email of the model to be evaluated
     * @return boolean
     */
    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    /**
     * Method to get a user by username
     *
     * @param usernameOrEmail  the username of the user to be retrieved
     * @return user with the given username
     */
    @Override
    public UserDto loadUserByUsername(String usernameOrEmail) throws NotFoundException {
        Optional<User> user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);

        if (user.isEmpty()) {
            throw new NotFoundException("User not found by username or email");
        }

        return persistenceMapper.entityToDto(user.get());
    }

    //Singleton pattern
    private UserPA() {

    }

    public static UserPA getInstance(Connection connection) {
        if (instance == null) {
            userRepository = UserRepositoryImpl.getInstance(connection);
            persistenceMapper = UserPM.getInstance();
            instance = new UserPA();
        }
        return instance;
    }

    private static UserPA instance;
    private static UserRepository userRepository;
    private static UserPM persistenceMapper;
}
