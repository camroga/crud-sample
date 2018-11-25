package dao.jpa;

import dao.CustomerDao;
import entity.Customer;
import exception.DaoException;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CustomerPersistence extends GenericPersistence implements CustomerDao {

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers;

        try {
            String sql = "select c from Customer c";
            Query query = entityManager.createQuery(sql);
            customers = (List<Customer>) query.getResultList();
        } catch (Exception ex) {
            throw new DaoException(ex.getMessage());
        }
        return customers;
    }
}
