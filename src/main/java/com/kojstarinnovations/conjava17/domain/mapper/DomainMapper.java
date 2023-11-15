package com.kojstarinnovations.conjava17.domain.mapper;

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
     * @param request
     * @return DTO
     */
    DTO requestToDto(REQUEST request);

    /**
     * Method to convert a dto to a response
     *
     * @param dto
     * @return RESPONSE
     */
    RESPONSE dtoToResponse(DTO dto);
}
