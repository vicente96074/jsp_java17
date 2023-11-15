package com.kojstarinnovations.conjava17.application.ports.input;

/**
 * Generic get use case
 *
 * @author Augusto Vicente
 * @param <Response>
 * @param <ID>
 */
public interface RetrieveUseCase<Response, ID> {

    /**
     * Get all objects
     *
     * @param id id of the object to be retrieved
     * @return QueryResponse
     */
    Response getById(ID id);
}
