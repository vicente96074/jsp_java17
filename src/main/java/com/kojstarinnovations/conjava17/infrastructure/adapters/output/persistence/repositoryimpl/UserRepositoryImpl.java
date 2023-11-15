package com.kojstarinnovations.conjava17.infrastructure.adapters.output.persistence.repositoryimpl;

import com.kojstarinnovations.conjava17.domain.connection.CustomizedConnection;
import com.kojstarinnovations.conjava17.domain.enums.ElementStatus;
import com.kojstarinnovations.conjava17.domain.exception.SQLExceptionCustomized;
import com.kojstarinnovations.conjava17.infrastructure.adapters.output.persistence.entity.User;
import com.kojstarinnovations.conjava17.infrastructure.adapters.output.persistence.repository.UserRepository;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Repository implementation for User
 *
 * @author Augusto Vicente
 */
public class UserRepositoryImpl implements UserRepository {
    /**
     * Method to save an entity in the database
     *
     * @param entity the entity to be saved
     * @return entity
     */
    @SneakyThrows(SQLExceptionCustomized.class)
    @Override
    public User save(User entity){
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            String insert = "INSERT INTO users (username, email, password, created_at, updated_at, created_by, updated_by, element_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            ps = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getUsername());
            ps.setString(2, entity.getEmail());
            ps.setString(3, entity.getPassword());
            ps.setTimestamp(4, Timestamp.valueOf(entity.getCreatedAt()));
            ps.setTimestamp(5, Timestamp.valueOf(entity.getUpdatedAt()));
            ps.setString(6, entity.getCreatedBy());
            ps.setString(7, entity.getUpdatedBy());
            ps.setString(8, entity.getElementStatus().toString());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();

            rs.next();
            entity.setId(rs.getInt(1)); // set id to the entity
            return entity;
        }catch (SQLException ex){
            throw new SQLExceptionCustomized("Error while saving user", ex);
        }finally {
            CustomizedConnection.closeResultSet(rs);
            CustomizedConnection.closePreparedStatement(ps);
        }
    }

    /**
     * Method to get an entity by id
     *
     * @param integer the id of the entity to be retrieved
     * @return entity with the given id
     */
    @SneakyThrows(SQLExceptionCustomized.class)
    @Override
    public Optional<User> getById(Integer integer) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try{
            String select = "SELECT * FROM users WHERE id = ?;";
            ps = connection.prepareStatement(select);
            ps.setInt(1, integer);
            rs = ps.executeQuery();
            rs.next();
            user = handle(rs);
        }catch (SQLException ex) {
            throw new SQLExceptionCustomized("Error while getting user by id", ex);
        }finally {
            CustomizedConnection.closeResultSet(rs);
            CustomizedConnection.closePreparedStatement(ps);
        }
        return Optional.ofNullable(user);
    }

    /**
     * Method to update an entity by id
     *
     * @param entity  the entity to be updated
     * @param integer the id of the entity to be updated
     * @return entity updated
     */
    @Override
    public User updateById(User entity, Integer integer) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            String update = "UPDATE users SET username = ?, email = ?, password = ?, updated_at = ?, updated_by = ?, element_status = ? WHERE id = ?;";
            ps = connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getUsername());
            ps.setString(2, entity.getEmail());
            ps.setString(3, entity.getPassword());
            ps.setTimestamp(4, Timestamp.valueOf(entity.getUpdatedAt()));
            ps.setString(5, entity.getUpdatedBy());
            ps.setString(6, entity.getElementStatus().toString());
            ps.setInt(7, integer);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();

            rs.next();
            entity.setId(rs.getInt(1));
            return entity;
        }catch (SQLException ex){
            throw new SQLExceptionCustomized("Error while updating user", ex);
        }finally {
            CustomizedConnection.closeResultSet(rs);
            CustomizedConnection.closePreparedStatement(ps);
        }
    }

    /**
     * Method to delete an entity by id
     *
     * @param integer the id of the entity to be deleted
     */
    @Override
    public void deleteById(Integer integer) {
        PreparedStatement ps = null;
        try{
            String delete = "DELETE FROM users WHERE id = ?;";
            ps = connection.prepareStatement(delete);
            ps.setInt(1, integer);
            ps.executeUpdate();
        }catch (SQLException ex){
            throw new SQLExceptionCustomized("Error while deleting user", ex);
        }finally {
            CustomizedConnection.closePreparedStatement(ps);
        }
    }

    /**
     * Method to evaluate if an entity exists by id
     *
     * @param integer the id of the entity to be evaluated
     * @return boolean
     */
    @Override
    public boolean existsById(Integer integer) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            String exists = "SELECT COUNT(*) FROM users WHERE id = ?;";
            ps = connection.prepareStatement(exists);
            ps.setInt(1, integer);
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        }catch (SQLException ex){
            throw new SQLExceptionCustomized("Error while evaluating if user exists", ex);
        } finally {
            CustomizedConnection.closeResultSet(rs);
            CustomizedConnection.closePreparedStatement(ps);
        }
    }

    /**
     * Method to find out if a user exists by username
     *
     * @param username the username to be checked
     * @return boolean true if exists otherwise false
     */
    @Override
    public boolean existsByUsername(String username) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            String exists = "SELECT COUNT(*) FROM users WHERE username = ?;";
            ps = connection.prepareStatement(exists);
            ps.setString(1, username);
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        }catch (SQLException ex){
            throw new SQLExceptionCustomized("Error while evaluating if user exists", ex);
        } finally {
            CustomizedConnection.closeResultSet(rs);
            CustomizedConnection.closePreparedStatement(ps);
        }
    }

    /**
     * Method to find out if a user exists by email
     *
     * @param email the email to be checked
     * @return boolean true if exists otherwise false
     */
    @Override
    public boolean existsByEmail(String email) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            String exists = "SELECT COUNT(*) FROM users WHERE email = ?;";
            ps = connection.prepareStatement(exists);
            ps.setString(1, email);
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        }catch (SQLException ex){
            throw new SQLExceptionCustomized("Error while evaluating if user exists", ex);
        } finally {
            CustomizedConnection.closeResultSet(rs);
            CustomizedConnection.closePreparedStatement(ps);
        }
    }

    /**
     * Method to get a user by username
     *
     * @param username the username of the user to be retrieved
     * @return user with the given username
     */
    @Override
    public Optional<User> findByUsernameOrEmail(String username, String email) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try{
            String select = "SELECT * FROM users WHERE username = ? OR email = ?;";
            ps = connection.prepareStatement(select);
            ps.setString(1, username);
            ps.setString(2, email);
            rs = ps.executeQuery();
            rs.next();
            user = handle(rs);
        }catch (SQLException ex) {
            Logger.getLogger(UserRepositoryImpl.class.getName()).log(Level.SEVERE, ex.getMessage());
        }finally {
            CustomizedConnection.closeResultSet(rs);
            CustomizedConnection.closePreparedStatement(ps);
        }

        return Optional.ofNullable(user);
    }

    /**
     * Method to handle the result set
     *
     * @param resultSet
     * @return T the result set handled
     * @throws java.sql.SQLException
     */
    @Override
    public User handle(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
        user.setCreatedBy(resultSet.getString("created_by"));
        user.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());
        user.setUpdatedBy(resultSet.getString("updated_by"));
        user.setElementStatus(ElementStatus.valueOf(resultSet.getString("element_status")));
        return user;
    }

    /**
     * Method to handle list of result set
     *
     * @param resultSet
     * @return List<T> the list of result set handled
     */
    @Override
    public List<User> handleList(ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<>();
        while (resultSet.next()){
            users.add(handle(resultSet));
        }

        return users;
    }

    //Singleton pattern
    private UserRepositoryImpl() {
    }

    public static UserRepositoryImpl getInstance(Connection connection) {
        if (instance == null) {
            instance = new UserRepositoryImpl();
            UserRepositoryImpl.connection = connection;
        }
        return instance;
    }

    private static UserRepositoryImpl instance;
    private static Connection connection;
}
