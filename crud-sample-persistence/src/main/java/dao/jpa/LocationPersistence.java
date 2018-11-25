package dao.jpa;

import dao.LocationDao;
import entity.Location;
import exception.DaoException;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class LocationPersistence extends GenericPersistence implements LocationDao {

    @Override
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
    }
}
