package com.kojstarinnovations.conjava17.application.ports.input;

/**
 * Generic save use case
 *
 * @author Augusto Vicente
 * @param <Request> Create request type
 * @param <Response> Query response type
 */
public interface CreateUseCase<Request, Response> {


    /**
     * Save entity
     *
     * @param request the entity to save
     * @return QueryResponse the saved entity
     */
    Response save(Request request);
}
