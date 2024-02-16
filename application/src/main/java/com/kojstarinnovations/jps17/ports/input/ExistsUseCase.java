package com.kojstarinnovations.jps17.ports.input;

/**
 * Generic exists use case
 *
 * @param <ID>
 * @author Augusto Vicente
 */
public interface ExistsUseCase<ID> {

    /**
     * Evaluate if the entity exists by id
     *
     * @param id id of the object to be checked
     * @return boolean
     */
    boolean existsById(ID id);
}
