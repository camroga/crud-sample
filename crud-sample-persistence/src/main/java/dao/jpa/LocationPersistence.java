package dao.jpa;

import dao.LocationDao;
import entity.Location;
import exception.DaoException;
import jdbc.PostgresJdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LocationPersistence implements LocationDao {

    @Override
    public Location getLocation(String customerId) {
        Location location = new Location();
        String SQL = "SELECT * FROM crud.location " +
                "WHERE " + customerId + " = crud.location.customerid";

        try (Connection conn = PostgresJdbc.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while(rs.next()) {
                location.setCustomerId(rs.getString("customerid"));
                location.setCity(rs.getString("city"));
                location.setPostCode(rs.getString("postCode"));
                location.setStreetAddress(rs.getString("streetAddress"));
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }

        return location;
    }
}
