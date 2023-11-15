package com.kojstarinnovations.conjava17.application.ports.output;

import java.util.Optional;

/**
 * Output port to handle the CRUD operations
 *
 * @author Augusto Vicente
 *
 * @param <T> the modelDto to be saved
 * @param <ID> the id of the modelDto
 */
public interface OutputPort<DTO, ID> {

    /**
     * Method to save a modelDto
     *
     * @param modelDto the modelDto to be saved
     * @return modelDto
     */
    DTO save(DTO modelDto);

    /**
     * Method to get a modelDto by id
     *
     * @param id the id of the modelDto to be retrieved
     * @return modelDto with the given id
     */
    Optional<DTO> getById(ID id);

    /**
     * Method to update a modelDto by id
     *
     * @param modelDto the modelDto to be updated
     * @param id the id of the modelDto to be updated
     * @return modelDto updated
     */
    DTO updateById(DTO modelDto, ID id);

    /**
     * Method to delete a model by id
     *
     * @param  id the id of the model to be deleted
     */
    void deleteById(ID id);

    /**
     * Method to evaluate if a model exists by id
     *
     * @param id the id of the model to be evaluated
     * @return boolean
     */
    boolean existsById(ID id);
}
