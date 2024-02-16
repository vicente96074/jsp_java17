package com.kojstarinnovations.jps17.pm;

import org.mapstruct.Mapper;

/**
 * PersistenceMapper
 *
 * @author Augusto Vicente
 * @param <ENTITY>
 * @param <DTO>
 */
@Mapper
public interface PersistenceMapper<ENTITY, DTO> {

    /**
     * The method to convert DTO to ENTITY
     *
     * @param dto is the data transfer object
     * @return the entity
     */
    public ENTITY dtoToEntity(DTO dto);

    /**
     * The method to convert ENTITY to DTO
     *
     * @param entity is the entity
     * @return the data transfer object
     */
    public DTO entityToDto(ENTITY entity);
}
