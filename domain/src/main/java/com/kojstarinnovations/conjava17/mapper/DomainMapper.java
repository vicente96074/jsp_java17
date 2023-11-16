package com.kojstarinnovations.conjava17.mapper;

/**
 * Interface for the domain mapper
 *
 * @param <DTO>
 * @param <REQUEST>
 * @param <RESPONSE>
 * @author Augusto Vicente
 */
public interface DomainMapper <DTO, REQUEST, RESPONSE>{

    /**
     * Method to convert a request to a dto
     *
     * @param request the request
     * @return DTO the dto
     */
    DTO requestToDto(REQUEST request);

    /**
     * Method to convert a dto to a response
     *
     * @param dto the dto
     * @return RESPONSE the response
     */
    RESPONSE dtoToResponse(DTO dto);
}
