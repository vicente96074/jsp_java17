package com.kojstarinnovations.jps17.ports.input;


/**
 * UseCase
 *
 * @param <Request> the type of the create request
 * @param <Response> the type of the query response
 * @param <ID> the type of the id
 * @author Augusto Vicente
 */
public interface UseCase<Request, Response, ID> extends CreateUseCase<Request, Response>,
        RetrieveUseCase<Response, ID>, UpdateUseCase<Request, Response, ID>, DeleteUseCase<ID>,
        ExistsUseCase<ID>{
}
