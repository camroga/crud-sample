package dao.jpa;

import dao.LocationDao;
import entity.Customer;
import entity.Location;
import exception.DaoException;
import jdbc.PostgresqlJDBC;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//@Stateless
public class LocationPersistence extends GenericPersistence implements LocationDao {

    /*@Override
    public Location getLocation(String customerId) {
        Location location;

        try {
            String sql = "select l from Location l where " +
                    "l.customerId = :customerId";
            Query query = entityManager.createQuery(sql).setParameter("customerId", customerId);
            location = (Location) query.getResultList();
        } catch (Exception ex) {
            throw new DaoException(ex.getMessage());
        }
        return location;
    }*/

    @Override
    public Location getLocation(String customerId) {
        Location location = new Location();
        String SQL = "SELECT crud.location.* FROM crud.location, crud.customer " +
                "WHERE " + customerId + " = crud.customer.id";

        try (Connection conn = PostgresqlJDBC.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while(rs.next()) {
                location.setCustomerId(rs.getString("customerId"));
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
