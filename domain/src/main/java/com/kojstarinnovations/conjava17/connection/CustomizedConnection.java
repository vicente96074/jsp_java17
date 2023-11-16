package com.kojstarinnovations.conjava17.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Custom class to handle the connection to the database
 *
 * @author Augusto Vicente
 */
public class CustomizedConnection {

    private static Connection connection;

    public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        if(connection == null){
            Properties properties = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
            properties.load(inputStream);
            String datasourceDriver = properties.getProperty("datasource.driver");
            String datasourceUrl = properties.getProperty("datasource.url");
            String datasourceUsername = properties.getProperty("datasource.username");
            String datasourcePassword = properties.getProperty("datasource.password");

            Class.forName(datasourceDriver);

            connection = DriverManager.getConnection(datasourceUrl, datasourceUsername, datasourcePassword);
        }

        return connection;
    }

    //Close result set
    public static void closeResultSet(ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //Close prepared statement
    public static void closePreparedStatement(PreparedStatement ps){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //Singleton pattern
    private CustomizedConnection() {
    }

    public static CustomizedConnection getInstance() {
        if (instance == null) {
            instance = new CustomizedConnection();
        }
        return instance;
    }

    private static CustomizedConnection instance;
}