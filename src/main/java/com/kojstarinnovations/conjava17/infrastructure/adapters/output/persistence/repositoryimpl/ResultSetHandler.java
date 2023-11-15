package com.kojstarinnovations.conjava17.infrastructure.adapters.output.persistence.repositoryimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * ResultSetHandler interface
 *
 * @param <T>
 * @author Augusto Vicente
 */
public interface ResultSetHandler<T>{
    /**
     * Method to handle the result set
     *
     * @return T the result set handled
     */
    T handle(ResultSet resultSet) throws SQLException;

    /**
     * Method to handle list of result set
     *
     * @return List<T> the list of result set handled
     */
    List<T> handleList(ResultSet resultSet) throws SQLException;
}
