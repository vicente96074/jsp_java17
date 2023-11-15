package com.kojstarinnovations.conjava17.infrastructure.adapters.output.persistence.mapper;

/**
 * Mapper interface for persistence
 *
 * @param <ENTITY>
 * @param <DTO>
 * @author Augusto Vicente
 */
public interface PersistenceMapper <ENTITY, DTO>{

    /**
     * Method to map a DTO to an entity
     *
     * @param dto the DTO to be mapped
     * @return the entity
     */
    ENTITY dtoToEntity(DTO dto);

    /**
     * Method to map an entity to a DTO
     *
     * @param entity the entity to be mapped
     * @return the DTO
     */
    DTO entityToDto(ENTITY entity);
}
