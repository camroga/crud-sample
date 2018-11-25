package jdbc;

import exception.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgresJdbc {

    private static final Logger LOGGER = Logger.getLogger(PostgresJdbc.class.getName());

    private static PostgresJdbc postgresJdbc = null;

    public static Connection getConnection() {
        if (postgresJdbc != null) {
            return postgresJdbc.getInstance();
        } else {
            try {
                PropertyDB.init();
                postgresJdbc = new PostgresJdbc();
                return postgresJdbc.getConnection();
            } catch (Exception e) {
                throw new DaoException(e.getMessage());
            }
        }
    }

    public Connection getInstance() {

        Connection connection;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new DaoException(e);
        }

        try {
            connection = DriverManager.getConnection(
                    PropertyDB.getProperty("url"),
                    PropertyDB.getProperty("user"),
                    PropertyDB.getProperty("password"));

        } catch (SQLException e) {
            throw new DaoException(e);
        }

        if (connection != null) {
            LOGGER.log(Level.FINE, "You made it, take control your database now!");
        } else {
            LOGGER.log(Level.SEVERE, "Failed to make connection!");
        }

        return connection;
    }

}
