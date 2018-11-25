package jdbc;

import exception.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgresJdbc {

    private static final Logger LOGGER = Logger.getLogger(PostgresJdbc.class.getName());

    public static Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new DaoException(e);
        }

        Connection connection;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/postgres?currentSchema=crud", "postgres", "postgres");
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
