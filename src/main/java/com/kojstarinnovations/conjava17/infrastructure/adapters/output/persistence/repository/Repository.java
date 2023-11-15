package com.kojstarinnovations.conjava17.infrastructure.adapters.output.persistence.repository;

import java.util.Optional;

/**
 * Repository interface
 *
 * @param <T>
 * @param <ID>
 * @author Augusto Vicente
 */
public interface Repository<T, ID>{

    /**
     * Method to save an entity in the database
     *
     * @param entity the entity to be saved
     * @return entity
     */
    T save(T entity);

    /**
     * Method to get an entity by id
     *
     * @param id the id of the entity to be retrieved
     * @return entity with the given id
     */
    Optional<T> getById(ID id);

    /**
     * Method to update an entity by id
     *
     * @param entity the entity to be updated
     * @param id     the id of the entity to be updated
     * @return entity updated
     */
    T updateById(T entity, ID id);

    /**
     * Method to delete an entity by id
     *
     * @param id the id of the entity to be deleted
     */
    void deleteById(ID id);

    /**
     * Method to evaluate if an entity exists by id
     *
     * @param id the id of the entity to be evaluated
     * @return boolean
     */
    boolean existsById(ID id);
}
