package com.kojstarinnovations.jps17.dm;

import org.mapstruct.Mapper;

/**
 * DomainMapper
 *
 * @param <Dto>
 * @param <Request>
 * @param <Response>
 *
 * @author Augusto Vicente
 */
@Mapper
public interface DomainMapper<Dto, Request, Response> {

    /**
     * A method to map a request to a dto
     *
     * @param request the request to be mapped
     * @return the mapped dto
     */
    Dto requestToDto(Request request);

    /**
     * A method to map a dto to a response
     *
     * @param dto the dto to be mapped
     * @return the mapped response
     */
    Response dtoToResponse(Dto dto);
}
